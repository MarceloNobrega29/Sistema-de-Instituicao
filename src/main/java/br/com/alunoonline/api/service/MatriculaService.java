package br.com.alunoonline.api.service;

import br.com.alunoonline.api.repository.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatriculaService {

    @Autowired
    MatriculaRepository matriculaRepository;
    
}
