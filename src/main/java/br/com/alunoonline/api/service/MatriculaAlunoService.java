package br.com.alunoonline.api.service;

import br.com.alunoonline.api.enuns.MatriculaAlunoStatusEnum;
import br.com.alunoonline.api.model.MatriculaAlunoModel;
import br.com.alunoonline.api.repository.MatriculaAlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class MatriculaAlunoService {

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
}
