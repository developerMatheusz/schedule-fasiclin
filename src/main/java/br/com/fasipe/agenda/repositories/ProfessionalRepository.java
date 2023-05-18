package br.com.fasipe.agenda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fasipe.agenda.entities.Professional;

public interface ProfessionalRepository extends JpaRepository<Professional, Long> {
    
}
