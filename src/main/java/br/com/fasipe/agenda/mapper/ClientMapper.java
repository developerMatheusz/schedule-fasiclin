package br.com.fasipe.agenda.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fasipe.agenda.dto.request.ClientDTORequest;
import br.com.fasipe.agenda.dto.response.ClientDTOResponse;
import br.com.fasipe.agenda.entities.Client;

@Component
public class ClientMapper {

    @Autowired
    private ModelMapper mapper;

    public ClientDTOResponse fromClientToClientDTOResponse(Client client) {
        return mapper.map(client, ClientDTOResponse.class);
    }

    public List<ClientDTOResponse> fromListClientToListClientDTOResponse(List<Client> clients) {
        return clients.stream()
            .map(client -> fromClientToClientDTOResponse(client))
            .collect(Collectors.toList());
    }

    public Client fromClientDTORequestToClient(ClientDTORequest clientDTORequest) {
        return mapper.map(clientDTORequest, Client.class);
    }
    
}
