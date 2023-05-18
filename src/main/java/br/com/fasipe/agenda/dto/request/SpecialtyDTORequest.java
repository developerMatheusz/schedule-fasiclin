package br.com.fasipe.agenda.dto.request;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class SpecialtyDTORequest {

    private Long idProcedimento;
    
    private String procedimento;

    private BigDecimal custoOperacional;

    private BigDecimal honorarios;

    private BigDecimal custoTotal;

}
