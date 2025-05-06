package br.com.alunoonline.api.model;

import br.com.alunoonline.api.enuns.MatricukaAlunoStatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "matricula_aluno")
@Entity
public class MatriculaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Double nota1;

    private Double nota2;

    @Enumerated(EnumType.STRING)
    private MatricukaAlunoStatusEnum status;

    @ManyToOne
    @JoinColumn(name = "disciplina_id")
    private DisciplinaModel disciplinaModel;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private AlunoModel alunoModel;
}
