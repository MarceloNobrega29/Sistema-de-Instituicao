package br.com.alunoonline.api.controller;

import br.com.alunoonline.api.model.ProfessorModel;
import br.com.alunoonline.api.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/professores")
public class ProfessorController {

    @Autowired
    ProfessorService professorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarProfessor(@RequestBody ProfessorModel professorModel) {
        professorService.criarProfessor(professorModel);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<ProfessorModel> buscarProfessorPorId(@PathVariable Long idProfessor) {
        return professorService.buscarProfessorPorId(idProfessor);
    }
    
}
