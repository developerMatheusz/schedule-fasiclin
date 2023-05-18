package br.com.fasipe.agenda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fasipe.agenda.entities.Specialty;

public interface SpecialtyRepository extends JpaRepository<Specialty, Long> {
    
}
