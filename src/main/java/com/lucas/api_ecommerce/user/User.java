package com.lucas.api_ecommerce.user;

import com.lucas.api_ecommerce.persona.Persona;
import com.lucas.api_ecommerce.user.UserType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;


import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class User extends Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String userId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable = false)
    private Date createdAt = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date deletedAt;

    private String createdBy;
    private String updatedBy;
    private String deletedBy;

    private Boolean isActive = true;

    @Enumerated(EnumType.STRING)
    private UserType userType;

}