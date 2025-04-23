package br.com.alunoonline.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "disciplina")
@Entity
public class DisciplinaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idDisciplina;

    private String nomeDisciplina;

    private Integer cargaHoraria;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private ProfessorModel professorModel;
    
}
