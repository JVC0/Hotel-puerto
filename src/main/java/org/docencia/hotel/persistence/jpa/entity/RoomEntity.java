package org.docencia.hotel.persistence.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "room")
public class RoomEntity {
    @Id
    private String id;
    @Column(name = "number")
    private String number;
    @Column(name = "type")
    private String type;
    @Column(name = "price_per_night")
    private double price_per_night;
    @ManyToOne
    @JoinColumn(name = "hotel_id", nullable = false)
    private HotelEntity hotel;

    public RoomEntity() {
    }

    public RoomEntity(String id) {
        this.id = id;
    }

    public RoomEntity(String id, String number, String type, double price_per_night, HotelEntity hotel) {
        this.id = id;
        this.number = number;
        this.type = type;
        this.price_per_night = price_per_night;
        this.hotel = hotel;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice_per_night() {
        return this.price_per_night;
    }

    public void setPrice_per_night(double price_per_night) {
        this.price_per_night = price_per_night;
    }

    public HotelEntity getHotel() {
        return this.hotel;
    }

    public void setHotel(HotelEntity hotel) {
        this.hotel = hotel;
    }

    public RoomEntity id(String id) {
        setId(id);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof RoomEntity)) {
            return false;
        }
        RoomEntity roomEntity = (RoomEntity) o;
        return Objects.equals(id, roomEntity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", number='" + getNumber() + "'" +
                ", type='" + getType() + "'" +
                ", price_per_night='" + getPrice_per_night() + "'" +
                ", hotel='" + getHotel() + "'" +
                "}";
    }

}