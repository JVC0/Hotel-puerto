package org.docencia.hotel.persistence.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "guest")
public class GuestEntity {
    // TODO: @Id + campos + relaciones
    private String id;
    private String full_name;
    private String email;
    private String phone;
}
