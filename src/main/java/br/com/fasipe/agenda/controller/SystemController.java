package br.com.fasipe.agenda.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fasipe.agenda.dto.request.ClientDTORequest;
import br.com.fasipe.agenda.dto.request.ProfessionalDTORequest;
import br.com.fasipe.agenda.dto.request.ScheduleDTORequest;
import br.com.fasipe.agenda.dto.request.SpecialtyDTORequest;
import br.com.fasipe.agenda.dto.response.ClientDTOResponse;
import br.com.fasipe.agenda.dto.response.ProfessionalDTOResponse;
import br.com.fasipe.agenda.dto.response.ScheduleDTOResponse;
import br.com.fasipe.agenda.dto.response.SpecialtyDTOResponse;
import br.com.fasipe.agenda.services.ClientService;
import br.com.fasipe.agenda.services.ProfessionalService;
import br.com.fasipe.agenda.services.ScheduleService;
import br.com.fasipe.agenda.services.SpecialtyService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/agenda")
public class SystemController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private SpecialtyService specialtyService;

    @Autowired
    private ProfessionalService professionalService;

    @Autowired
    private ScheduleService scheduleService;

    //Endpoints client
    @GetMapping("/clientes")
    public List<ClientDTOResponse> findAllClients() {
        return clientService.findAllClients();
    }

    @GetMapping("/cliente/{cpf}")
    public ClientDTOResponse findByCpfClient(@PathVariable String cpf) {
        return clientService.findByCpfClient(cpf);
    }

    @PostMapping("/inserir/cliente")
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, String> saveClient(@Valid @RequestBody ClientDTORequest clientDTORequest, BindingResult result) {
        return clientService.saveClient(clientDTORequest, result);
    }

    //Endpoints specialty
    @GetMapping("/especialidade")
    public List<SpecialtyDTOResponse> findAllSpecialtys() {
        return specialtyService.findAllSpecialtys();
    }

    @GetMapping("/especialidade/{id}")
    public SpecialtyDTOResponse findByIdSpecialty(@PathVariable Long id) {
        return specialtyService.findByIdSpecialty(id);
    }

    @PostMapping("/inserir/especialidade")
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, String> saveSpecialty(@Valid @RequestBody SpecialtyDTORequest specialtyDTORequest, BindingResult result) {
        return specialtyService.saveSpecialty(specialtyDTORequest, result);
    }

    //Endpoints professional
    @GetMapping("/profissional")
    public List<ProfessionalDTOResponse> findAllProfessionals() {
        return professionalService.findAllProfessionals();
    }

    @GetMapping("/profissional/{id}")
    public ProfessionalDTOResponse findByIdProfessional(@PathVariable Long id) {
        return professionalService.findByIdProfessional(id);
    }

    @PostMapping("/inserir/profissional")
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, String> saveProfessional(@Valid @RequestBody ProfessionalDTORequest professionalDTORequest, BindingResult result) {
        return professionalService.saveProfessional(professionalDTORequest, result);
    }

    //Endpoints schedule
    @GetMapping("/agendamento")
    public List<ScheduleDTOResponse> findAllSchedules() {
        return scheduleService.findAllSchedules();
    }

    @GetMapping("/agendamento/{id}")
    public ScheduleDTOResponse findByIdSchedule(@PathVariable Long id) {
        return scheduleService.findByIdSchedule(id);
    }

    @PostMapping("/inserir/agendamento")
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, String> saveSchedule(@Valid @RequestBody ScheduleDTORequest scheduleDTORequest, BindingResult result) {
        return scheduleService.saveSchedule(scheduleDTORequest, result);
    }
    
}
