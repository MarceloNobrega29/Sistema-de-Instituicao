package br.com.alunoonline.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "aluno")
@Entity
public class AlunoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idAluno;

    private String nomeAluno;

    private String cpfAluno;

    private String emailAluno;

}