package br.com.alunoonline.api.service;

import br.com.alunoonline.api.model.DisciplinaModel;
import br.com.alunoonline.api.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
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

    public void atualizarDisciplinaPorId(Long idDisciplina, DisciplinaModel disciplinaModel) {
        DisciplinaModel disciplinaBancoDeDados = disciplinaRepository.findById(idDisciplina).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Disciplina não encontrada"));

        disciplinaBancoDeDados.setNomeDisciplina(disciplinaModel.getNomeDisciplina());
        disciplinaBancoDeDados.setCargaHoraria(disciplinaModel.getCargaHoraria());

        disciplinaRepository.save(disciplinaBancoDeDados);
    }

    public List<DisciplinaModel> listarTodasDisciplinas() {
        return disciplinaRepository.findAll();
    }

    public List<DisciplinaModel> listarDisciplinasDoProf(Long idProfessor) {
        return disciplinaRepository.findByProfessorModel_IdProfessor(idProfessor);
    }
}
