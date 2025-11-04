package com.leadscope.leadscopepro.infra.web;

import com.leadscope.leadscopepro.core.lead.model.Lead;
import com.leadscope.leadscopepro.infra.web.dto.LeadResponse;


// Mapper específico da camada web: domínio -> DTO de resposta.
// Mantém controllers enxutos e sem "montar JSON na mão".
final class LeadWebMapper {

    static LeadResponse toResponse(Lead d) {
        return new LeadResponse(
                d.getId(),
                d.getName(),
                d.getEmail(),
                d.getPhone(),
                d.getScore()
        );
    }

    private LeadWebMapper() {}
}
