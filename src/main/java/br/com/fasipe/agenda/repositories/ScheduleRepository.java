package br.com.fasipe.agenda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fasipe.agenda.entities.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    
}
