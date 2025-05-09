package br.com.alunoonline.api.controller;

import br.com.alunoonline.api.model.ProfessorModel;
import br.com.alunoonline.api.service.ProfessorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/professores")
public class ProfessorController {

    @Autowired
    ProfessorService professorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Cadastrar professor", description = "Registra um novo professor no sistema")
    @ApiResponse(responseCode = "201", description = "Professor cadastrado com sucesso")
    public void criarProfessor(@RequestBody ProfessorModel professorModel) {
        professorService.criarProfessor(professorModel);
    }

    @GetMapping("/{idProfessor}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Buscar professor por ID", description = "Obtém os dados de um professor específico")
    @ApiResponse(responseCode = "200", description = "Professor encontrado")
    public Optional<ProfessorModel> buscarProfessorPorId(@PathVariable Long idProfessor) {
        return professorService.buscarProfessorPorId(idProfessor);
    }

    @DeleteMapping(("/{idProfessor}"))
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Remover professor", description = "Exclui permanentemente um professor do sistema")
    @ApiResponse(responseCode = "200", description = "Professor excluído com sucesso")
    public void deletarProfessorPorId(@PathVariable Long idProfessor) {
        professorService.deletarProfessorPorId(idProfessor);
    }

    @PutMapping("/{idProfessor}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Atualizar professor", description = "Altera os dados cadastrais de um professor")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Professor atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Professor não encontrado")
    })
    public void atualizarProfessorPorId(@PathVariable ("idProfessor") Long idProfessor, @RequestBody ProfessorModel professorModel) {
        professorService.atualizarProfessorPorId(idProfessor, professorModel);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Listar professores", description = "Retorna todos os professores cadastrados")
    @ApiResponse(responseCode = "200", description = "Lista de professores retornada com sucesso")
    public List<ProfessorModel> listarTodosProfessores() {
        return professorService.listarTodosProfessores();
    }

}
