package br.com.fasipe.agenda.dto.request;

import java.sql.Date;

import lombok.Data;

@Data
public class ScheduleDTORequest {

    private Date dataAbertura;

    private String nomeProfissional;

    private ClientDTORequest cliente;

    private SpecialtyDTORequest especialidade;

    private ProfessionalDTORequest profissional;
    
}
