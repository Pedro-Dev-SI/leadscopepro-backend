package com.leadscope.leadscopepro.core.lead.ports;

import com.leadscope.leadscopepro.core.lead.model.Lead;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


// "Porta" do domínio: o domínio declara o que precisa da persistência.
// Não diz COMO salvar. Apenas define as operações.

public interface LeadRepositoryPort {

    Optional<Lead> findByLeadId(UUID leadId);
    Optional<Lead> findByEmail(String email);

    Lead save(Lead lead);

    List<Lead> findAll();
}
