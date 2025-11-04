package com.leadscope.leadscopepro.infra.web.dto;

import java.util.UUID;

// DTO de saída da API: representa o JSON que devolvemos ao cliente.
public record LeadResponse(
        UUID id,
        String name,
        String email,
        String phone,
        Integer score
) {}
