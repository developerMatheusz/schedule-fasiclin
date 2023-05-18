package br.com.fasipe.agenda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fasipe.agenda.entities.Client;

public interface ClientRepository extends JpaRepository<Client, String> {

    Client findByCpfCliente(String cpf);
    
}
