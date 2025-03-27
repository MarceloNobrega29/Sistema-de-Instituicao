package br.com.alunoonline.api.service;

import br.com.alunoonline.api.model.Aluno;
import br.com.alunoonline.api.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        alunoRepository.save(aluno);
    }


}