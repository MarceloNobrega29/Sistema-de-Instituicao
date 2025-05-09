package br.com.alunoonline.api.controller;

import br.com.alunoonline.api.model.MatriculaAlunoModel;
import br.com.alunoonline.api.service.MatriculaAlunoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/matriculas")
public class MatriculaAlunoController {

    @Autowired
    MatriculaAlunoService matriculaAlunoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Cria uma nova matrícula", description = "Cadastra uma nova matrícula de aluno no sistema.")
    @ApiResponse(responseCode = "201", description = "Matrícula criada com sucesso")
    public void criarMatricula(@RequestBody MatriculaAlunoModel matriculaAlunoModel) {
        matriculaAlunoService.criarMatricula(matriculaAlunoModel);
    }

    @PatchMapping("/trancar/{idMatricula}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Trancar matrícula", description = "Altera o status da matrícula para trancado.")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Matrícula trancada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Matrícula não encontrada"),
            @ApiResponse(responseCode = "400", description = "Só é possivel trancar com o estatus MATRICULADO"),
    })
    public void trancarMatricula(@PathVariable Long idMatricula) {
        matriculaAlunoService.trancarMatricula(idMatricula);
    }

}
