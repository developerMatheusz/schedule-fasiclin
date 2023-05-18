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

import br.com.fasipe.agenda.dto.request.ProfessionalDTORequest;
import br.com.fasipe.agenda.dto.response.ProfessionalDTOResponse;
import br.com.fasipe.agenda.entities.Professional;
import br.com.fasipe.agenda.mapper.ProfessionalMapper;
import br.com.fasipe.agenda.repositories.ProfessionalRepository;

@Service
public class ProfessionalService {

    @Autowired
    private ProfessionalRepository professionalRepository;

    @Autowired
    private ProfessionalMapper professionalMapper;

    public List<ProfessionalDTOResponse> findAllProfessionals() {
        List<Professional> professionals = professionalRepository.findAll();
        
        return professionalMapper.fromListProfessionalToListProfessionalDTOResponse(professionals);
    }

    public ProfessionalDTOResponse findByIdProfessional(Long id) {
        Professional professional = professionalRepository.findById(id).get();

        return professionalMapper.fromProfessionalToProfessionalDTOResponse(professional);
    }

    @Transactional
    public Map<String, String> saveProfessional(ProfessionalDTORequest professionalDTORequest, BindingResult result) {
        Map<String, String> errors = new HashMap<>();

        if (result.hasErrors()) {
            for (FieldError error : result.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }

            return errors;
        }

        Professional professional = professionalMapper.fromProfessionalDTORequestToProfessional(professionalDTORequest);

        professionalRepository.save(professional);

        return Collections.singletonMap("mensagem", "Profissional de saúde cadastrado com sucesso!");
    }
    
}
