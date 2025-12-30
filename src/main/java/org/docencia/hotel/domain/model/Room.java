package org.docencia.hotel.domain.model;
import java.util.Objects;

public class Room {
    private String id ;
    private String number;
    private String type;
    private double price_per_night;
    private String hotle_id;
    public Room(String id) {
        this.id =id;
    }
    public Room() {
    }

    public Room(String id, String number, String type, double price_per_night, String hotle_id) {
        this.id = id;
        this.number = number;
        this.type = type;
        this.price_per_night = price_per_night;
        this.hotle_id = hotle_id;
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

    public String getHotle_id() {
        return this.hotle_id;
    }

    public void setHotle_id(String hotle_id) {
        this.hotle_id = hotle_id;
    }

    public Room id(String id) {
        setId(id);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Room)) {
            return false;
        }
        Room room = (Room) o;
        return Objects.equals(id, room.id) ;
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
            ", hotle_id='" + getHotle_id() + "'" +
            "}";
    }
    
}
