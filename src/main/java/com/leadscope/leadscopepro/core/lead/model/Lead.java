package com.leadscope.leadscopepro.core.lead.model;

import com.leadscope.leadscopepro.shared.vo.Email;
import com.leadscope.leadscopepro.shared.vo.Phone;

import java.time.OffsetDateTime;
import java.util.UUID;

// Entidade de domínio "pura": sem anotações do JPA ou Spring.
// Representa o conceito de "Lead" dentro do negócio.

public class Lead {

    private UUID id;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
    private String name;
    private Email email;
    private Phone phone;
    private Integer score;

    // Fábrica estática para garantir invariantes
    public static Lead create(String name, String emailRaw, String phoneRaw) {
        var lead = new Lead();
        lead.createdAt = OffsetDateTime.now();
        lead.updatedAt = lead.createdAt;
        lead.name = name;
        lead.email = Email.of(emailRaw);
        lead.phone = Phone.of(phoneRaw);
        lead.score = 0;
        return lead;
    }

    public void touch() { this.updatedAt = OffsetDateTime.now(); }

    private static String requiredName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (name.length() > 120) {
            throw new IllegalArgumentException("Name cannot be longer than 120 characters");
        }
        return name.trim();
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

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
