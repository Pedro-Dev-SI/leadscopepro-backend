package com.leadscope.leadscopepro.shared.vo;

import java.util.Objects;
import java.util.regex.Pattern;

public class Email {
    private static final Pattern RE =
            Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");

    private final String value;

    private Email(String value) { this.value = value; }

    public static Email of(String raw) {
        if (raw == null || raw.isBlank()) {
            throw new IllegalArgumentException("Email é obrigatório");
        }
        var normalized = raw.trim().toLowerCase();
        if (!RE.matcher(normalized).matches()) {
            throw new IllegalArgumentException("Email inválido: " + raw);
        }
        return new Email(normalized);
    }

    public String value() { return value; }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Email e)) return false;
        return Objects.equals(value, e.value);
    }
    @Override public int hashCode() { return Objects.hash(value); }
    @Override public String toString() { return value; }
}
