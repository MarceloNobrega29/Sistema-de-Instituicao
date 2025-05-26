package br.com.alunoonline.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "professor")
@Entity
public class ProfessorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idProfessor;

    private String nomeProfessor;

    private String cpfProfessor;

    private String emailProfessor;

}
