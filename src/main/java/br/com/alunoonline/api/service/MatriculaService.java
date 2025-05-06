package br.com.alunoonline.api.service;

import br.com.alunoonline.api.enuns.MatricukaAlunoStatusEnum;
import br.com.alunoonline.api.model.MatriculaModel;
import br.com.alunoonline.api.repository.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatriculaService {

    @Autowired
    MatriculaRepository matriculaRepository;

    public void criarMatricula(MatriculaModel matriculaModel) {
        matriculaModel.setStatus(MatricukaAlunoStatusEnum.MATRICULADO);
        matriculaRepository.save(matriculaModel);
    }
    
}
