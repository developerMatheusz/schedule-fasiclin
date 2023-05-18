package br.com.fasipe.agenda.entities;

import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "ag_agenda")
@Entity
public class Schedule {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAgenda;

    @CreationTimestamp
    private Date dataAbertura;

    private String nomeProfissional;

    @ManyToOne
    @JoinColumn(name = "cpfCliente")
    private Client cliente;

    @ManyToOne
    @JoinColumn(name = "idProcedimento")
    private Specialty especialidade;

    @ManyToOne
    @JoinColumn(name = "idProfissional")
    private Professional profissional;

}
