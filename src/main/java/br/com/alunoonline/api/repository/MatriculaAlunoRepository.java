package br.com.alunoonline.api.repository;

import br.com.alunoonline.api.model.MatriculaAlunoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaAlunoRepository extends JpaRepository<MatriculaAlunoModel, Long> {
}
