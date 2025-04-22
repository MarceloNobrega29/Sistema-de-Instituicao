package br.com.alunoonline.api.controller;

import br.com.alunoonline.api.model.AlunoModel;
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
        public void criarAluno(@RequestBody AlunoModel alunoModel) {
                alunoService.criarAluno(alunoModel);
        }

        @GetMapping("/{id}")
        @ResponseStatus(HttpStatus.OK)
        public Optional<AlunoModel> buscarAlunoPorId(@PathVariable Long id) {
            return alunoService.buscarAlunoPorId(id);

        }

        @DeleteMapping(("/{id}"))
        @ResponseStatus(HttpStatus.OK)
        public void deletarAlunoPorId(@PathVariable Long id) {
            alunoService.deletarAlunoPorId(id);
        }

        @PutMapping("/{id}")
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public void atualizarAlunoPorId(@PathVariable("id") Long id, @RequestBody AlunoModel alunoModel) {
                alunoService.atualizarAlunoPorId(id, alunoModel);
        }

        @GetMapping
        @ResponseStatus(HttpStatus.OK)
        public List<AlunoModel> listarTodosAlunos() {
                return alunoService.listarTodosAlunos();
        }

}