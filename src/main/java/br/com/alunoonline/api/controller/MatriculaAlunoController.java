package br.com.alunoonline.api.controller;

import br.com.alunoonline.api.dtos.AtualizarNotasRequestDTO;
import br.com.alunoonline.api.dtos.HistoricoAlunoResponseDTO;
import br.com.alunoonline.api.model.MatriculaAlunoModel;
import br.com.alunoonline.api.service.MatriculaAlunoService;
import io.swagger.v3.oas.annotations.Operation;
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
    @Operation(summary = "Cria uma nova matrícula", description = "Cadastra uma nova matrícula de aluno no sistema")
    public void criarMatricula(@RequestBody MatriculaAlunoModel matriculaAlunoModel) {
        matriculaAlunoService.criarMatricula(matriculaAlunoModel);
    }

    @PatchMapping("/trancar/{idMatricula}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Trancar matrícula", description = "Altera o status da matrícula para trancado por ID")
    public void trancarMatricula(@PathVariable Long idMatricula) {
        matriculaAlunoService.trancarMatricula(idMatricula);
    }

    @PatchMapping("/atualizar-notas/{idMatricula}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Atualizar Notas", description = "Atualiza as notas de uma matricula por ID")
    public void atualizarNotas(@PathVariable Long idMatricula, @RequestBody AtualizarNotasRequestDTO atualizarNotasRequestDTO) {
        matriculaAlunoService.atualizarNotas(idMatricula, atualizarNotasRequestDTO);
    }

    @GetMapping("/emitir-historico/{idAluno}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Emitir historico", description = "Emite o histórico acadêmico do aluno com base no ID informado.")
    public HistoricoAlunoResponseDTO emitirHistorico(@PathVariable Long idAluno) {
        return matriculaAlunoService.emitirHistorico(idAluno);
    }

}
