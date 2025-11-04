package com.leadscope.leadscopepro.infra.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

// Interface do Spring Data JPA: gera CRUD e consultas automáticas.
// Repara que lida com a ENTIDADE JPA (LeadJpaEntity), não com a do domínio (Lead).
@Repository
public interface SpringDataLeadRepository extends JpaRepository<LeadJpaEntity, UUID> {
    Optional<LeadJpaEntity> findByEmail(String email);
}
