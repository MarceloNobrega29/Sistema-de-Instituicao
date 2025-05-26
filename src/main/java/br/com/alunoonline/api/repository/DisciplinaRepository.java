package br.com.alunoonline.api.repository;

import br.com.alunoonline.api.model.DisciplinaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DisciplinaRepository extends JpaRepository<DisciplinaModel, Long> {

    List<DisciplinaModel> findByProfessorModel_IdProfessor(Long idProfessor);

}
