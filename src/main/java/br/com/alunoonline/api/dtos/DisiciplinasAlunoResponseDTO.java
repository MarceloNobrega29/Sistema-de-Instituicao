package br.com.alunoonline.api.dtos;

import br.com.alunoonline.api.enuns.MatriculaAlunoStatusEnum;
import lombok.Data;

@Data
public class DisiciplinasAlunoResponseDTO {

    private String nomeDisciplina;
    private String nomeProfessor;
    private Double nota1;
    private Double nota2;
    private Double media;
    private MatriculaAlunoStatusEnum status;

}
