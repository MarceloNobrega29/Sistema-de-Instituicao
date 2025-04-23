package br.com.alunoonline.api.controller;

import br.com.alunoonline.api.model.DisciplinaModel;
import br.com.alunoonline.api.service.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {

    @Autowired
    DisciplinaService disciplinaService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void criarDisciplina(@RequestBody DisciplinaModel disciplinaModel) {
        disciplinaService.criarDisciplina(disciplinaModel);
    }

    @GetMapping("/{idDisciplina}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<DisciplinaModel> buscarDisciplinaPorId(@PathVariable Long idDisciplina) {
        return disciplinaService.buscarDisciplinaPorId(idDisciplina);
    }

    @DeleteMapping(("/{idDisciplina}"))
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarDisciplinaPorId(@PathVariable Long idDisciplina) {
        disciplinaService.deletarDisciplinaPorId(idDisciplina);
    }

}
