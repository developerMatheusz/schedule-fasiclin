package br.com.fasipe.agenda.dto.request;

import lombok.Data;

@Data
public class ProfessionalDTORequest {

    private Long idProfissional;
    
    private String nomeProfissional;

    private String especialidade;

}
