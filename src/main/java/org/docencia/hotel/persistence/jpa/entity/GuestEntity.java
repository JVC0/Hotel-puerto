package org.docencia.hotel.persistence.jpa.entity;

import org.docencia.hotel.domain.model.GuestPreferences;

import jakarta.persistence.*;
import java.util.Objects;


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

    @Transient
    private GuestPreferences preferences;

    public GuestEntity() {
    }
    public GuestEntity(String id) {
        this.id = id;
    }

    public GuestEntity(String id, String full_name, String email, String phone, GuestPreferences preferences) {
        this.id = id;
        this.full_name = full_name;
        this.email = email;
        this.phone = phone;
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
            ", preferences='" + getPreferences() + "'" +
            "}";
    }
    
}
