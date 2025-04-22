package br.com.alunoonline.api.service;

import br.com.alunoonline.api.model.ProfessorModel;
import br.com.alunoonline.api.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfessorService {

    @Autowired
    ProfessorRepository professorRepository;

    public void criarProfessor(ProfessorModel professorModel) {
        professorRepository.save(professorModel);
    }

    public Optional<ProfessorModel> buscarProfessorPorId(Long idProfessor) {
        return professorRepository.findById(idProfessor);
    }
    
}
