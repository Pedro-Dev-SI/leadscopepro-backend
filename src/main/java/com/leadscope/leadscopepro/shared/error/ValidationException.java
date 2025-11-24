package com.leadscope.leadscopepro.shared.error;

public class ValidationException extends DomainException {
    public ValidationException(String detail) {
        super("validation.error", detail);
    }
}
