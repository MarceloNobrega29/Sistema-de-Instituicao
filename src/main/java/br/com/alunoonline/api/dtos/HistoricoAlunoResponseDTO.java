package br.com.alunoonline.api.dtos;

import lombok.Data;
import java.util.List;

@Data
public class HistoricoAlunoResponseDTO {

    private String nomeAluno;
    private String email;
    private String cpf;
    private List<DisiciplinasAlunoResponseDTO> disiciplinas;

}
