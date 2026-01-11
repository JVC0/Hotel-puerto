package org.docencia.hotel.persistence.jpa.entity;

import java.util.*;

import org.docencia.hotel.domain.model.GuestPreferences;

import jakarta.persistence.*;

@Entity
@Table(name = "guest")
public class GuestEntity {
    @Id
    private String id;
    @Column(name = "full_name")
    private String full_name;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @OneToMany(mappedBy = "guest")
    private List<BookingEntity> booking;

    @Transient
    private GuestPreferences preferences;

    public GuestEntity() {
    }

    public GuestEntity(String id) {
        this.id = id;
    }

    public GuestEntity(String id, String full_name, String email, String phone, List<BookingEntity> booking,
            GuestPreferences preferences) {
        this.id = id;
        this.full_name = full_name;
        this.email = email;
        this.phone = phone;
        this.booking = booking;
        this.preferences = preferences;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFull_name() {
        return this.full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<BookingEntity> getBooking() {
        return this.booking;
    }

    public void setBooking(List<BookingEntity> booking) {
        this.booking = booking;
    }

    public GuestPreferences getPreferences() {
        return this.preferences;
    }

    public void setPreferences(GuestPreferences preferences) {
        this.preferences = preferences;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof GuestEntity)) {
            return false;
        }
        GuestEntity guestEntity = (GuestEntity) o;
        return Objects.equals(id, guestEntity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", full_name='" + getFull_name() + "'" +
                ", email='" + getEmail() + "'" +
                ", phone='" + getPhone() + "'" +
                ", booking='" + getBooking() + "'" +
                ", preferences='" + getPreferences() + "'" +
                "}";
    }

}
