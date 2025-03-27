package br.com.alunoonline.api.controller;

import br.com.alunoonline.api.model.Aluno;
import br.com.alunoonline.api.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

        @Autowired
        AlunoService alunoService;

        @PostMapping
        @ResponseStatus(HttpStatus.CREATED)
        public void criarAluno(@RequestBody Aluno aluno) {
                alunoService.criarAluno(aluno);
        }

        @GetMapping("/{id}")
        @ResponseStatus(HttpStatus.OK)
        public Optional<Aluno> obterPorId(@PathVariable Long id) {
            return alunoService.buscarPorId(id);

        }

        @DeleteMapping(("/{id}"))
        @ResponseStatus(HttpStatus.OK)
        public void deletar(@PathVariable Long id) {
            alunoService.deletarAluno(id);
        }

        @PutMapping("/{id}")
        @ResponseStatus(HttpStatus.OK)
        public void atualizarAluno(@PathVariable("id") Long id, @RequestBody Aluno aluno) {
                alunoService.atualizarAluno(id, aluno);
        }

        @GetMapping
        @ResponseStatus(HttpStatus.OK)
        public List<Aluno> buscar(@RequestParam("nome") String nome) {
                return alunoService.buscarAluno(nome);
        }

}