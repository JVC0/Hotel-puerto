package org.docencia.hotel.persistence.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "room")
public class RoomEntity {
    // TODO: @Id + campos + relaciones
    private String id ;
    private String number;
    private String type;
    private double price_per_night;
    private String hotle_id;
}
