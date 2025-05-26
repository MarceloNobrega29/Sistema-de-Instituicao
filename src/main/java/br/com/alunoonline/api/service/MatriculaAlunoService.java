package br.com.alunoonline.api.service;

import br.com.alunoonline.api.dtos.AtualizarNotasRequestDTO;
import br.com.alunoonline.api.dtos.DisiciplinasAlunoResponseDTO;
import br.com.alunoonline.api.dtos.HistoricoAlunoResponseDTO;
import br.com.alunoonline.api.enuns.MatriculaAlunoStatusEnum;
import br.com.alunoonline.api.model.DisciplinaModel;
import br.com.alunoonline.api.model.MatriculaAlunoModel;
import br.com.alunoonline.api.repository.MatriculaAlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MatriculaAlunoService {

    private static final Double MEDIA_PARA_APROVACAO = 7.0;
    private static final Integer QTD_NOTAS = 2;

    @Autowired
    MatriculaAlunoRepository matriculaAlunoRepository;

    public void criarMatricula(MatriculaAlunoModel matriculaAlunoModel) {
        matriculaAlunoModel.setStatus(MatriculaAlunoStatusEnum.MATRICULADO);
        matriculaAlunoRepository.save(matriculaAlunoModel);
    }

    public void trancarMatricula(Long matriculaAlunoId) {

        // Antes de trancar, verificar se a matricula existe

        MatriculaAlunoModel matriculaAlunoModel = matriculaAlunoRepository.findById(matriculaAlunoId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Matricula aluno não foi encontrada."));

        // Só vai deixar trancar, se o estatus ATUAL for MATRICULADO

        if (matriculaAlunoModel.getStatus().equals(MatriculaAlunoStatusEnum.MATRICULADO)) {
            matriculaAlunoModel.setStatus(MatriculaAlunoStatusEnum.TRANCADO);
            matriculaAlunoRepository.save(matriculaAlunoModel);
        } else {
            throw  new ResponseStatusException(HttpStatus.BAD_REQUEST, "Só é possivel trancar com o estatus MATRICULADO.");
        }

    }

    public void atualizarNotas(Long matriculaAlunoId, AtualizarNotasRequestDTO atualizarNotasRequestDTO) {
        MatriculaAlunoModel matriculaAluno = buscarMatriculaOuLancarExecao(matriculaAlunoId);

        if (atualizarNotasRequestDTO.getNota1() != null) {
            matriculaAluno.setNota1(atualizarNotasRequestDTO.getNota1());
        }
        if (atualizarNotasRequestDTO.getNota2() != null) {
            matriculaAluno.setNota2(atualizarNotasRequestDTO.getNota2());
        }

        calcularMediaEmodificarStatus(matriculaAluno);
        matriculaAlunoRepository.save(matriculaAluno);
    }

    public HistoricoAlunoResponseDTO emitirHistorico(Long idAluno) {
        List<MatriculaAlunoModel> matriculaAlunos = matriculaAlunoRepository.findByAlunoModel_IdAluno(idAluno);

        if (matriculaAlunos.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Esse aluno não possui matriculas");
        }
        HistoricoAlunoResponseDTO historicoAluno = new HistoricoAlunoResponseDTO();

        historicoAluno.setNomeAluno(matriculaAlunos.get(0).getAlunoModel().getNomeAluno());
        historicoAluno.setEmail(matriculaAlunos.get(0).getAlunoModel().getEmailAluno());
        historicoAluno.setCpf(matriculaAlunos.get(0).getAlunoModel().getCpfAluno());

        List<DisiciplinasAlunoResponseDTO> disciplinas = matriculaAlunos.stream()
                .map(this::mapearParaDisciplinasAlunosResponseDTO).toList();

        historicoAluno.setDisiciplinas(disciplinas);
        return historicoAluno;

    }

//  Metodo auxiliar. Metodos auxiliares são sempre no final.
    private MatriculaAlunoModel buscarMatriculaOuLancarExecao(Long matriculaAlunoId) {
        return matriculaAlunoRepository.findById(matriculaAlunoId).
                orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Matricula do Aluno não encontrada"));
    }

    private void calcularMediaEmodificarStatus(MatriculaAlunoModel matriculaAluno) {
        Double nota1 = matriculaAluno.getNota1();
        Double nota2 = matriculaAluno.getNota2();

        if (nota1 != null && nota2 != null) {
            Double media = (nota1 + nota2) / QTD_NOTAS;            // ? = if e : = else
            matriculaAluno.setStatus(media >= MEDIA_PARA_APROVACAO ? MatriculaAlunoStatusEnum.APROVADO : MatriculaAlunoStatusEnum.REPROVADO);
        }
    }

    private DisiciplinasAlunoResponseDTO mapearParaDisciplinasAlunosResponseDTO(MatriculaAlunoModel matriculaAluno) {
        DisiciplinasAlunoResponseDTO response = new DisiciplinasAlunoResponseDTO();

        response.setNomeDisciplina(matriculaAluno.getDisciplinaModel().getNomeDisciplina());
        response.setNomeProfessor(matriculaAluno.getDisciplinaModel().getProfessorModel().getNomeProfessor());
        response.setNota1(matriculaAluno.getNota1());
        response.setNota2(matriculaAluno.getNota2());
        response.setMedia(calcularMedia(matriculaAluno.getNota1(), matriculaAluno.getNota2()));
        response.setStatus(matriculaAluno.getStatus());

        return response;
    }

    private Double calcularMedia(Double nota1, Double nota2) {
        return (nota1 != null && nota2 != null) ? (nota1 + nota2) / QTD_NOTAS : null;

    }

}
