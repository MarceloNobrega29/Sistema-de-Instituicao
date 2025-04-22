package br.com.alunoonline.api.service;

import br.com.alunoonline.api.model.AlunoModel;
import br.com.alunoonline.api.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    AlunoRepository alunoRepository;

    public void criarAluno(AlunoModel alunoModel) {
        alunoRepository.save(alunoModel);
    }

    public Optional<AlunoModel> buscarAlunoPorId(Long id) {
        return alunoRepository.findById(id);
    }

    public void deletarAlunoPorId(Long id) {
        alunoRepository.deleteById(id);
    }

    public void atualizarAlunoPorId(Long id, AlunoModel alunoModel) {
        AlunoModel alunoModelExistente = alunoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado"));

        alunoModelExistente.setNome(alunoModel.getNome());
        alunoModelExistente.setEmail(alunoModel.getEmail());

        alunoRepository.save(alunoModelExistente);
    }

    public List<AlunoModel> listarTodosAlunos() {
        return alunoRepository.findAll();
    }

}