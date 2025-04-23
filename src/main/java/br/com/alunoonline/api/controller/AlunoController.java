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

        @GetMapping("/{idAluno}")
        @ResponseStatus(HttpStatus.OK)
        public Optional<AlunoModel> buscarAlunoPorId(@PathVariable Long idAluno) {
            return alunoService.buscarAlunoPorId(idAluno);

        }

        @DeleteMapping(("/{idAluno}"))
        @ResponseStatus(HttpStatus.OK)
        public void deletarAlunoPorId(@PathVariable Long idAluno) {
            alunoService.deletarAlunoPorId(idAluno);
        }

        @PutMapping("/{idAluno}")
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public void atualizarAlunoPorId(@PathVariable("idAluno") Long idAluno, @RequestBody AlunoModel alunoModel) {
                alunoService.atualizarAlunoPorId(idAluno, alunoModel);
        }

        @GetMapping
        @ResponseStatus(HttpStatus.OK)
        public List<AlunoModel> listarTodosAlunos() {
                return alunoService.listarTodosAlunos();
        }

}