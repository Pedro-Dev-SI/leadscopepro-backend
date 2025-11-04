package com.leadscope.leadscopepro.infra.db;

import com.leadscope.leadscopepro.core.lead.model.Lead;


// Mapper entre "domínio" e "JPA" (ida e volta).
// Mantém a tradução em um único lugar (boa prática).
final class LeadJpaMapper {

    // Converte do domínio para a entidade JPA (para salvar no banco)
    static LeadJpaEntity toEntity(Lead d) {
        var e = new LeadJpaEntity();
        e.setId(d.getId());
        e.setName(d.getName());
        e.setEmail(d.getEmail());
        e.setPhone(d.getPhone());
        e.setScore(d.getScore());
        e.setCreatedAt(d.getCreatedAt());
        e.setUpdatedAt(d.getUpdatedAt());

        return e;
    }

    // Converte da entidade JPA para o domínio (para usar no service/controller)
    static Lead toDomain(LeadJpaEntity e) {
        var d = new Lead();
        d.setId(e.getId());
        d.setName(e.getName());
        d.setEmail(e.getEmail());
        d.setPhone(e.getPhone());
        d.setScore(e.getScore());
        d.setCreatedAt(e.getCreatedAt());
        d.setUpdatedAt(e.getUpdatedAt());
        return d;
    }

    private LeadJpaMapper() {} //Evita instanciar (classe utilitária)


}
