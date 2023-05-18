package br.com.fasipe.agenda.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "ag_cliente_precad")
@Entity
public class Client {

    @Id
    private String cpfCliente;

    private String nomeCliente;

    private String telefone;
    
}
