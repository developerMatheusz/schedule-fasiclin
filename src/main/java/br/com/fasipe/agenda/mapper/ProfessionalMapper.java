package br.com.fasipe.agenda.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fasipe.agenda.dto.request.ProfessionalDTORequest;
import br.com.fasipe.agenda.dto.response.ProfessionalDTOResponse;
import br.com.fasipe.agenda.entities.Professional;

@Component
public class ProfessionalMapper {

    @Autowired
    private ModelMapper mapper;

    public ProfessionalDTOResponse fromProfessionalToProfessionalDTOResponse(Professional professional) {
        return mapper.map(professional, ProfessionalDTOResponse.class);
    }

    public List<ProfessionalDTOResponse> fromListProfessionalToListProfessionalDTOResponse(List<Professional> professionals) {
        return professionals.stream()
            .map(professional -> fromProfessionalToProfessionalDTOResponse(professional))
            .collect(Collectors.toList());
    }

    public Professional fromProfessionalDTORequestToProfessional(ProfessionalDTORequest professionalDTORequest) {
        return mapper.map(professionalDTORequest, Professional.class);
    }
    
}
