package br.com.fasipe.agenda.services;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import br.com.fasipe.agenda.dto.request.ClientDTORequest;
import br.com.fasipe.agenda.dto.response.ClientDTOResponse;
import br.com.fasipe.agenda.entities.Client;
import br.com.fasipe.agenda.mapper.ClientMapper;
import br.com.fasipe.agenda.repositories.ClientRepository;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientMapper clientMapper;

    public List<ClientDTOResponse> findAllClients() {
        List<Client> clients = clientRepository.findAll();
        
        return clientMapper.fromListClientToListClientDTOResponse(clients);
    }

    public ClientDTOResponse findByCpfClient(String cpf) {
        Client client = clientRepository.findByCpfCliente(cpf);

        return clientMapper.fromClientToClientDTOResponse(client);
    }

    @Transactional
    public Map<String, String> saveClient(ClientDTORequest clientDTORequest, BindingResult result) {
        Map<String, String> errors = new HashMap<>();

        if (result.hasErrors()) {
            for (FieldError error : result.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }

            return errors;
        }

        Client client = clientMapper.fromClientDTORequestToClient(clientDTORequest);

        clientRepository.save(client);

        return Collections.singletonMap("mensagem", "Cliente criado com sucesso!");
    }
    
}
