package br.com.fasipe.agenda.entities;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "ag_exames_e_procedimentos")
@Entity
public class Specialty {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProcedimento;

    private String procedimento;

    private BigDecimal custoOperacional;

    private BigDecimal honorarios;

    private BigDecimal custoTotal;

}
