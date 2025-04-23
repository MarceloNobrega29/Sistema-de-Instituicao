package br.com.alunoonline.api.service;

import br.com.alunoonline.api.model.DisciplinaModel;
import br.com.alunoonline.api.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DisciplinaService {

    @Autowired
    DisciplinaRepository disciplinaRepository;

    public void criarDisciplina(DisciplinaModel disciplinaModel) {
        disciplinaRepository.save(disciplinaModel);
    }

    public Optional<DisciplinaModel> buscarDisciplinaPorId(Long idDisciplina) {
        return disciplinaRepository.findById(idDisciplina);
    }

    public void deletarDisciplinaPorId(Long idDisciplina) {
        disciplinaRepository.deleteById(idDisciplina);
    }
    

}
