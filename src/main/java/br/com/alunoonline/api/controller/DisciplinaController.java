package br.com.alunoonline.api.controller;

import br.com.alunoonline.api.model.DisciplinaModel;
import br.com.alunoonline.api.service.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {

    @Autowired
    DisciplinaService disciplinaService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void criarDisciplina(DisciplinaModel disciplinaModel) {
        disciplinaService.criarDisciplina(disciplinaModel);
    }
    

}
