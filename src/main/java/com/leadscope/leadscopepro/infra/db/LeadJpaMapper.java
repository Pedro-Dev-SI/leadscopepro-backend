package com.leadscope.leadscopepro.infra.db;

import com.leadscope.leadscopepro.core.lead.model.Lead;
import com.leadscope.leadscopepro.shared.vo.Email;
import com.leadscope.leadscopepro.shared.vo.Phone;


// Mapper entre "domínio" e "JPA" (ida e volta).
// Mantém a tradução em um único lugar (boa prática).
final class LeadJpaMapper {

    // Converte do domínio para a entidade JPA (para salvar no banco)
    static LeadJpaEntity toEntity(Lead d) {
        var e = new LeadJpaEntity();
        e.setName(d.getName());
        e.setEmail(d.getEmail() != null ? d.getEmail().value() : null);
        e.setPhone(d.getPhone()  !=  null ? d.getPhone().value() : null);
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
        d.setEmail(Email.of(e.getEmail()));
        d.setPhone(Phone.of(e.getPhone()));
        d.setScore(e.getScore());
        d.setCreatedAt(e.getCreatedAt());
        d.setUpdatedAt(e.getUpdatedAt());
        return d;
    }

    private LeadJpaMapper() {} //Evita instanciar (classe utilitária)


}
