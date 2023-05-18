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

import br.com.fasipe.agenda.dto.request.ScheduleDTORequest;
import br.com.fasipe.agenda.dto.response.ScheduleDTOResponse;
import br.com.fasipe.agenda.entities.Schedule;
import br.com.fasipe.agenda.mapper.ScheduleMapper;
import br.com.fasipe.agenda.repositories.ScheduleRepository;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private ScheduleMapper scheduleMapper;

    public List<ScheduleDTOResponse> findAllSchedules() {
        List<Schedule> schedules = scheduleRepository.findAll();
        
        return scheduleMapper.fromListScheduleToListScheduleDTOResponse(schedules);
    }

    public ScheduleDTOResponse findByIdSchedule(Long id) {
        Schedule schedule = scheduleRepository.findById(id).get();

        return scheduleMapper.fromScheduleToScheduleDTOResponse(schedule);
    }

    @Transactional
    public Map<String, String> saveSchedule(ScheduleDTORequest scheduleDTORequest, BindingResult result) {
        Map<String, String> errors = new HashMap<>();

        if (result.hasErrors()) {
            for (FieldError error : result.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }

            return errors;
        }

        Schedule schedule = scheduleMapper.fromScheduleDTORequestToSchedule(scheduleDTORequest);

        scheduleRepository.save(schedule);

        return Collections.singletonMap("mensagem", "Agendamento cadastrado com sucesso!");
    }
    
}
