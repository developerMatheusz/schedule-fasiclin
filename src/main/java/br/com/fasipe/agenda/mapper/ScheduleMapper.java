package br.com.fasipe.agenda.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fasipe.agenda.dto.request.ScheduleDTORequest;
import br.com.fasipe.agenda.dto.response.ScheduleDTOResponse;
import br.com.fasipe.agenda.entities.Schedule;

@Component
public class ScheduleMapper {

    @Autowired
    private ModelMapper mapper;

    public ScheduleDTOResponse fromScheduleToScheduleDTOResponse(Schedule schedule) {
        return mapper.map(schedule, ScheduleDTOResponse.class);
    }

    public List<ScheduleDTOResponse> fromListScheduleToListScheduleDTOResponse(List<Schedule> schedules) {
        return schedules.stream()
            .map(schedule -> fromScheduleToScheduleDTOResponse(schedule))
            .collect(Collectors.toList());
    }

    public Schedule fromScheduleDTORequestToSchedule(ScheduleDTORequest scheduleDTORequest) {
        return mapper.map(scheduleDTORequest, Schedule.class);
    }
    
}
