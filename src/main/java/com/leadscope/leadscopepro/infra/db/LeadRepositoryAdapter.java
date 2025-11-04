package com.leadscope.leadscopepro.infra.db;

import com.leadscope.leadscopepro.core.lead.model.Lead;
import com.leadscope.leadscopepro.core.lead.ports.LeadRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;


// Adapter concreto que IMPLEMENTA a porta do domínio usando JPA.
// O domínio chama a porta; a infra realiza o "trabalho sujo" com a tecnologia.

@Component()
public class LeadRepositoryAdapter implements LeadRepositoryPort {

    private final SpringDataLeadRepository repo;

    public LeadRepositoryAdapter(SpringDataLeadRepository repo) {
        this.repo = repo;
    }


    @Override
    public Optional<Lead> findByLeadId(UUID leadId) {
        return repo.findById(leadId).map(LeadJpaMapper::toDomain);
    }

    @Override
    public Optional<Lead> findByEmail(String email) {
        return repo.findByEmail(email).map(LeadJpaMapper::toDomain);
    }

    @Override
    public Lead save(Lead lead) {
        var savedLead = repo.save(LeadJpaMapper.toEntity(lead));
        return LeadJpaMapper.toDomain(savedLead);
    }

    @Override
    public List<Lead> findAll() {
        return repo.findAll().stream().map(LeadJpaMapper::toDomain).collect(Collectors.toList());
    }
}
