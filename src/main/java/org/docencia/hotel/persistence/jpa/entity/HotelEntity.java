package org.docencia.hotel.persistence.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "hotel")
public class HotelEntity {
    // TODO: @Id + campos + relaciones
    private String id;
    private String name;
    private String address;
}
