package org.docencia.hotel.domain.model;

import java.util.Objects;

public class Room {
    private String id;
    private String number;
    private String type;
    private double pricePerNight;
    private Hotel hotel;

    public Room(String id) {
        this.id = id;
    }

    public Room() {
    }

    public Room(String id, String number, String type, double pricePerNight, Hotel hotel) {
        this.id = id;
        this.number = number;
        this.type = type;
        this.pricePerNight = pricePerNight;
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

    public double getPricePerNight() {
        return this.pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public Hotel getHotel() {
        return this.hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Room)) {
            return false;
        }
        Room room = (Room) o;
        return Objects.equals(id, room.id);
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
                ", pricePerNight='" + getPricePerNight() + "'" +
                ", hotel='" + getHotel() + "'" +
                "}";
    }
}