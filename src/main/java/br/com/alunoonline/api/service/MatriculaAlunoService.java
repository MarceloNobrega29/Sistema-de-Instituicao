package br.com.alunoonline.api.service;

import br.com.alunoonline.api.dtos.AtualizarNotasRequestDTO;
import br.com.alunoonline.api.enuns.MatriculaAlunoStatusEnum;
import br.com.alunoonline.api.model.MatriculaAlunoModel;
import br.com.alunoonline.api.repository.MatriculaAlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

}
