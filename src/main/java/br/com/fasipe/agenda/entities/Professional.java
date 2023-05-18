package br.com.fasipe.agenda.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "ag_profissional")
@Entity
public class Professional {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProfissional;

    private String nomeProfissional;

    private String especialidade;

}
