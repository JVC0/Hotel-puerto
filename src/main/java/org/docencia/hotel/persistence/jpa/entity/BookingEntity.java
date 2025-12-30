package org.docencia.hotel.persistence.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "booking")
public class BookingEntity {
    // TODO: @Id + campos + relaciones
    @Id
    private String id;
    private String room_id;
    private String guest_id;
    private String check_in;
    private String check_out;
}
