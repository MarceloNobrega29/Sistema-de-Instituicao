package br.com.alunoonline.api.service;

import br.com.alunoonline.api.model.Aluno;
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

    public void criarAluno(Aluno aluno) {
        alunoRepository.save(aluno);
    }

    public Optional<Aluno> buscarPorId(Long id) {
        return alunoRepository.findById(id);
    }

    public void deletarAluno(Long id) {
        alunoRepository.deleteById(id);
    }

    public void atualizarAluno(Long id, Aluno aluno) {
        Aluno alunoExistente = alunoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado"));

        alunoExistente.setNome(aluno.getNome());
        alunoExistente.setCpf(aluno.getCpf());
        alunoExistente.setEmail(aluno.getEmail());

        alunoRepository.save(alunoExistente);
    }

    public List<Aluno> buscarAluno(String nome) {
        return alunoRepository.findByNomeContaining(nome);
    }

}