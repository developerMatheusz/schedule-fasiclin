package br.com.fasipe.agenda.dto.response;

import java.sql.Date;

import lombok.Data;

@Data
public class ScheduleDTOResponse {

    private Long idAgenda;

    private Date dataAbertura;

    private String nomeProfissional;

    private ClientDTOResponse cliente;

    private SpecialtyDTOResponse especialidade;

    private ProfessionalDTOResponse profissional;
    
}
