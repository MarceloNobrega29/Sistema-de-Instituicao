package br.com.alunoonline.api.controller;

import br.com.alunoonline.api.model.DisciplinaModel;
import br.com.alunoonline.api.service.DisciplinaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {

    @Autowired
    DisciplinaService disciplinaService;


    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Criar disciplina", description = "Cadastra uma nova disciplina no sistema.")
    @ApiResponse(responseCode = "200", description = "Disciplina criada com sucesso")
    public void criarDisciplina(@RequestBody DisciplinaModel disciplinaModel) {
        disciplinaService.criarDisciplina(disciplinaModel);
    }

    @GetMapping("/{idDisciplina}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Buscar disciplina", description = "Recupera os dados de uma disciplina específica por ID")
    @ApiResponse(responseCode = "200", description = "Disciplina encontrada")
    public Optional<DisciplinaModel> buscarDisciplinaPorId(@PathVariable Long idDisciplina) {
        return disciplinaService.buscarDisciplinaPorId(idDisciplina);
    }

    @DeleteMapping(("/{idDisciplina}"))
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Excluir disciplina", description = "Remove permanentemente uma disciplina do sistema por ID")
    @ApiResponse(responseCode = "204", description = "Disciplina excluída com sucesso")
    public void deletarDisciplinaPorId(@PathVariable Long idDisciplina) {
        disciplinaService.deletarDisciplinaPorId(idDisciplina);
    }

    @PutMapping("/{idDisciplina}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Atualizar disciplina", description = "Altera os dados de uma disciplina existente por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Disciplina atualizada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Disciplina não encontrada")
    })
    public void atualizarDisciplinaPorId(@PathVariable ("idDisciplina") Long idDisciplina, @RequestBody DisciplinaModel disciplinaModel) {
        disciplinaService.atualizarDisciplinaPorId(idDisciplina, disciplinaModel);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Listar todas disciplinas", description = "Retorna uma lista com todas as disciplinas cadastradas.")
    @ApiResponse(responseCode = "200", description = "Lista de disciplinas retornada com sucesso")
    public List<DisciplinaModel> listarTodasDisciplinas() {
        return disciplinaService.listarTodasDisciplinas();
    }

}
