package org.docencia.hotel.persistence.jpa.entity;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "hotel")
public class HotelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;

    public HotelEntity() {
    }

    public HotelEntity(String id) {
        this.id = id;
    }

    public HotelEntity(String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof HotelEntity)) {
            return false;
        }
        HotelEntity hotelEntity = (HotelEntity) o;
        return Objects.equals(id, hotelEntity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", name='" + getName() + "'" +
                ", address='" + getAddress() + "'" +
                "}";
    }

}
