package com.leadscope.leadscopepro.core.lead.model;

import java.time.OffsetDateTime;
import java.util.UUID;

// Entidade de domínio "pura": sem anotações do JPA ou Spring.
// Representa o conceito de "Lead" dentro do negócio.

public class Lead {

    private UUID id;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
    private String name;
    private String email;
    private String phone;
    private Integer score;

    // Fábrica estática para garantir invariantes
    public static Lead create(String name, String email, String phone) {
        var lead = new Lead();
        lead.id = UUID.randomUUID();
        lead.createdAt = OffsetDateTime.now();
        lead.updatedAt = lead.createdAt;
        lead.name = name;
        lead.email = email;
        lead.phone = phone;
        lead.score = 0;
        return lead;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
