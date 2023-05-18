package br.com.fasipe.agenda.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fasipe.agenda.dto.request.SpecialtyDTORequest;
import br.com.fasipe.agenda.dto.response.SpecialtyDTOResponse;
import br.com.fasipe.agenda.entities.Specialty;

@Component
public class SpecialtyMapper {

    @Autowired
    private ModelMapper mapper;

    public SpecialtyDTOResponse fromSpecialtyToSpecialtyDTOResponse(Specialty specialty) {
        return mapper.map(specialty, SpecialtyDTOResponse.class);
    }

    public List<SpecialtyDTOResponse> fromListSpecialtyToListSpecialtyDTOResponse(List<Specialty> specialtys) {
        return specialtys.stream()
            .map(specialty -> fromSpecialtyToSpecialtyDTOResponse(specialty))
            .collect(Collectors.toList());
    }

    public Specialty fromSpecialtyDTORequestToSpecialty(SpecialtyDTORequest specialtyDTORequest) {
        return mapper.map(specialtyDTORequest, Specialty.class);
    }
    
}
