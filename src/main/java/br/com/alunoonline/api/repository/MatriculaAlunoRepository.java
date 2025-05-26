package br.com.alunoonline.api.repository;

import br.com.alunoonline.api.model.MatriculaAlunoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatriculaAlunoRepository extends JpaRepository<MatriculaAlunoModel, Long> {

    List<MatriculaAlunoModel> findByAlunoModel_IdAluno(Long idAluno);

}
