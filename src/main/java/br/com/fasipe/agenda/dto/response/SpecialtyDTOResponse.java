package br.com.fasipe.agenda.dto.response;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class SpecialtyDTOResponse {

    private Long idProcedimento;
    
    private String procedimento;

    private BigDecimal custoOperacional;

    private BigDecimal honorarios;

    private BigDecimal custoTotal;

}
