package br.com.alunoonline.api.service;

import br.com.alunoonline.api.model.ProfessorModel;
import br.com.alunoonline.api.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
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

    public void deletarProfessorPorId(Long idProfessor) {
        professorRepository.deleteById(idProfessor);
    }

    public void atualizarProfessorPorId(Long idProfessor, ProfessorModel professorModel) {
        ProfessorModel professorBancoDeDados = professorRepository.findById(idProfessor)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Professor não encontrado"));

        professorBancoDeDados.setNomeProfessor(professorModel.getNomeProfessor());
        professorBancoDeDados.setEmailProfessor(professorModel.getEmailProfessor());

        professorRepository.save(professorBancoDeDados);
    }

    public List<ProfessorModel> listarTodosProfessores() {
        return professorRepository.findAll();
    }

}
