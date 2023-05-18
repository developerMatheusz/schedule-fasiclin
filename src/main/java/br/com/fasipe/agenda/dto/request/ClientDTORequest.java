package br.com.fasipe.agenda.dto.request;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ClientDTORequest {
    
    @Size(min = 11, max = 11)
    private String cpfCliente;

    @Size(max = 80)
    private String nomeCliente;

    @Size(max = 20)
    private String telefone;

}
