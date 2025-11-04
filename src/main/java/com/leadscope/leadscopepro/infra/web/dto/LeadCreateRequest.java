package com.leadscope.leadscopepro.infra.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

// DTO de entrada da API: representa o JSON que o cliente envia no POST.
// Fica na camada web porque é contrato HTTP, não do domínio.
public record LeadCreateRequest(
        @NotBlank @Size(max=120) String name,
        @NotBlank @Email @Size(max=120) String email,
        @Size(max=40) String phone
) {}
