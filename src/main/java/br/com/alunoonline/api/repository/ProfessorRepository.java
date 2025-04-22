package br.com.alunoonline.api.repository;

import br.com.alunoonline.api.model.ProfessorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<ProfessorModel, Long> {

}
