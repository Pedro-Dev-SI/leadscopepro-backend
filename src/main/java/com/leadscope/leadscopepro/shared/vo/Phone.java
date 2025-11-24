package com.leadscope.leadscopepro.shared.vo;

import java.util.Objects;

public class Phone {
    private final String value;

    private Phone(String value) { this.value = value; }

    public static Phone of(String raw) {
        if (raw == null || raw.isBlank()) return null; // telefone opcional
        var normalized = raw.trim();
        if (normalized.length() > 40) {
            throw new IllegalArgumentException("Telefone muito longo");
        }
        return new Phone(normalized);
    }

    public String value() { return value; }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Phone p)) return false;
        return Objects.equals(value, p.value);
    }
    @Override public int hashCode() { return Objects.hash(value); }
    @Override public String toString() { return value; }
}
