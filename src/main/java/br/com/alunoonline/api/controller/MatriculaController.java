package br.com.alunoonline.api.controller;

import br.com.alunoonline.api.model.MatriculaModel;
import br.com.alunoonline.api.service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

    @Autowired
    MatriculaService matriculaService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarMatricula(@RequestBody MatriculaModel matriculaModel) {
        matriculaService.criarMatricula(matriculaModel);
    }

}
