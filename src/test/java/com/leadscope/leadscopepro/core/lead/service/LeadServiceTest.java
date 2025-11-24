package com.leadscope.leadscopepro.core.lead.service;

import com.leadscope.leadscopepro.core.lead.model.Lead;
import com.leadscope.leadscopepro.core.lead.ports.LeadRepositoryPort;
import com.leadscope.leadscopepro.shared.error.DuplicatedEmailException;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LeadServiceTest {

    static class InMemoryRepo implements LeadRepositoryPort {
        private final Map<String, Lead> byEmail = new HashMap<>();
        private final Map<UUID, Lead> byId = new HashMap<>();

        @Override
        public Optional<Lead> findByLeadId(UUID leadId) {
            return Optional.ofNullable(byId.get(leadId));
        }

        @Override
        public Optional<Lead> findByEmail(String email) {
            return Optional.ofNullable(byEmail.get(email.toLowerCase()));
        }
        @Override
        public Lead save(Lead lead) {
            byEmail.put(lead.getEmail().value(), lead);
            byId.put(lead.getId(), lead);
            return lead;
        }
        @Override
        public List<Lead> findAll() { return new ArrayList<>(byEmail.values()); }
    }

    @Test
    void shouldCreateLead() {
        var service = new LeadService(new InMemoryRepo());
        var created = service.create("Ada", "ada@io.com", "+55 35 9xxx");
        assertEquals("Ada", created.getName());
        assertEquals("ada@io.com", created.getEmail().value());
    }

    @Test
    void shouldRejectDuplicateEmail() {
        var repo = new InMemoryRepo();
        var service = new LeadService(repo);
        service.create("Ada", "ada@io.com", null);
        assertThrows(DuplicatedEmailException.class,
                () -> service.create("Ada 2", "ada@io.com", null));
    }
}
