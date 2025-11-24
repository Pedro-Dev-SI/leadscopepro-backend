package com.leadscope.leadscopepro.core.lead.service;

import com.leadscope.leadscopepro.core.lead.model.Lead;
import com.leadscope.leadscopepro.core.lead.ports.LeadRepositoryPort;
import com.leadscope.leadscopepro.shared.error.DuplicatedEmailException;

import java.util.List;

// Caso de uso do domínio: orquestra regras de aplicação.
// Não conhece Spring (sem @Service aqui). O bean é criado na borda web.
public class LeadService {

    private final LeadRepositoryPort repo;

    public LeadService(LeadRepositoryPort repo) {
        this.repo = repo;
    }

    public Lead create(String name, String email, String phone) {
        repo.findByEmail(email).ifPresent(l -> {
            throw new DuplicatedEmailException(email);
        });

        var lead = Lead.create(name, email, phone);
        return repo.save(lead);
    }

    public List<Lead> findAll() {
        return repo.findAll();
    }
}
