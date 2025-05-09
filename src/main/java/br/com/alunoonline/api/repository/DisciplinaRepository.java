package br.com.alunoonline.api.repository;

import br.com.alunoonline.api.model.DisciplinaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplinaRepository extends JpaRepository<DisciplinaModel, Long> {

}
