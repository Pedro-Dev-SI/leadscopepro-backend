package com.leadscope.leadscopepro.infra.db;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.OffsetDateTime;
import java.util.UUID;


// Entidade JPA que espelha o domínio, mas vive na infra.
// É o "formato" que o JPA entende para guardar no banco.

@Entity
@Table(name = "lead")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class LeadJpaEntity {

    @Id
    @UuidGenerator
    private UUID id;

    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private OffsetDateTime updatedAt;

    @Column(nullable = false, length = 120)
    private String name;

    @Column(nullable = false, length = 160, unique = true)
    private String email;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private Integer score;

}
