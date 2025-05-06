package br.com.alunoonline.api.controller;

import br.com.alunoonline.api.service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

    @Autowired
    MatriculaService matriculaService;

}
