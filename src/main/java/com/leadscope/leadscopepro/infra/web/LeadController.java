package com.leadscope.leadscopepro.infra.web;

import com.leadscope.leadscopepro.core.lead.ports.LeadRepositoryPort;
import com.leadscope.leadscopepro.core.lead.service.LeadService;
import com.leadscope.leadscopepro.infra.web.dto.LeadCreateRequest;
import com.leadscope.leadscopepro.infra.web.dto.LeadResponse;
import jakarta.validation.Valid;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Controller REST: recebe HTTP, valida, delega ao domínio e devolve DTO.
@RestController
@RequestMapping("/api/v1/leads")
public class LeadController {

    // Depende do caso de uso do domínio (LeadService).
    private final LeadService service;

    LeadController(LeadService service) { this.service = service; }

    @PostMapping
    LeadResponse create(@RequestBody @Valid LeadCreateRequest req) {
        var lead = service.create(req.name(), req.email(), req.phone());
        return LeadWebMapper.toResponse(lead);
    }

    @GetMapping
    List<LeadResponse> list() {
        return service.findAll().stream().map(LeadWebMapper::toResponse).toList();
    }
}

// Classe de configuração que "monta" o bean do domínio sem poluir o domínio com @Service.
// Aqui conectamos a porta (LeadRepositoryPort) no caso de uso (LeadService).
@Configuration
class LeadBeans {
    @Bean
    LeadService leadService(LeadRepositoryPort repo) {
        return new LeadService(repo); // domínio continua sem Spring
    }
}
