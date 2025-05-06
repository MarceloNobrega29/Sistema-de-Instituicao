package br.com.alunoonline.api.repository;

import br.com.alunoonline.api.model.MatriculaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaRepository extends JpaRepository<MatriculaModel, Long> {
}
