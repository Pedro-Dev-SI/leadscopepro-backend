package com.leadscope.leadscopepro.shared.error;

public class DuplicatedEmailException extends DomainException {
    public DuplicatedEmailException(String email) {
        super("lead.email.duplicated", "Email já cadastrado: " + email);
    }
}
