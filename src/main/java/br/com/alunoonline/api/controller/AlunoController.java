package br.com.alunoonline.api.controller;

import br.com.alunoonline.api.model.AlunoModel;
import br.com.alunoonline.api.service.AlunoService;
import io.swagger.v3.oas.annotations.Operation;
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
        @Operation(summary = "Cadastrar aluno", description = "Cria um novo registro de aluno no sistema")
        public void criarAluno(@RequestBody AlunoModel alunoModel) {
                alunoService.criarAluno(alunoModel);
        }

        @GetMapping("/{idAluno}")
        @ResponseStatus(HttpStatus.OK)
        @Operation(summary = "Buscar aluno", description = "Busca um aluno pelo por ID")
        public Optional<AlunoModel> buscarAlunoPorId(@PathVariable Long idAluno) {
                return alunoService.buscarAlunoPorId(idAluno);
        }

        @DeleteMapping(("/{idAluno}"))
        @ResponseStatus(HttpStatus.OK)
        @Operation(summary = "Excluir aluno", description = "Remove um aluno do sistema por ID")
        public void deletarAlunoPorId(@PathVariable Long idAluno) {
                alunoService.deletarAlunoPorId(idAluno);
        }

        @PutMapping("/{idAluno}")
        @ResponseStatus(HttpStatus.NO_CONTENT)
        @Operation(summary = "Atualizar aluno", description = "Atualiza os dados de um aluno existente por ID")
        public void atualizarAlunoPorId(@PathVariable("idAluno") Long idAluno, @RequestBody AlunoModel alunoModel) {
                alunoService.atualizarAlunoPorId(idAluno, alunoModel);
        }

        @GetMapping
        @ResponseStatus(HttpStatus.OK)
        @Operation(summary = "Listar alunos", description = "Retorna todos os alunos cadastrados")
        public List<AlunoModel> listarTodosAlunos() {
                return alunoService.listarTodosAlunos();
        }
}