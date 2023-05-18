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

import br.com.fasipe.agenda.dto.request.SpecialtyDTORequest;
import br.com.fasipe.agenda.dto.response.SpecialtyDTOResponse;
import br.com.fasipe.agenda.entities.Specialty;
import br.com.fasipe.agenda.mapper.SpecialtyMapper;
import br.com.fasipe.agenda.repositories.SpecialtyRepository;

@Service
public class SpecialtyService {

    @Autowired
    private SpecialtyRepository specialtyRepository;

    @Autowired
    private SpecialtyMapper specialtyMapper;

    public List<SpecialtyDTOResponse> findAllSpecialtys() {
        List<Specialty> specialtys = specialtyRepository.findAll();
        
        return specialtyMapper.fromListSpecialtyToListSpecialtyDTOResponse(specialtys);
    }

    public SpecialtyDTOResponse findByIdSpecialty(Long id) {
        Specialty specialty = specialtyRepository.findById(id).get();

        return specialtyMapper.fromSpecialtyToSpecialtyDTOResponse(specialty);
    }

    @Transactional
    public Map<String, String> saveSpecialty(SpecialtyDTORequest specialtyDTORequest, BindingResult result) {
        Map<String, String> errors = new HashMap<>();

        if (result.hasErrors()) {
            for (FieldError error : result.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }

            return errors;
        }

        Specialty specialty = specialtyMapper.fromSpecialtyDTORequestToSpecialty(specialtyDTORequest);

        specialtyRepository.save(specialty);

        return Collections.singletonMap("mensagem", "Exame/procedimento cadastrado com sucesso!");
    }
    
}
