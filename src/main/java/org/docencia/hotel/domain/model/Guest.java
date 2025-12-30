package org.docencia.hotel.domain.model;
import java.util.Objects;

public class Guest {
    private String id;
    private String full_name;
    private String email;
    private String phone;
    public Guest(String id) {
        this.id=id;
    }
    public Guest() {
    }

    public Guest(String id, String full_name, String email, String phone) {
        this.id = id;
        this.full_name = full_name;
        this.email = email;
        this.phone = phone;
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



    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Guest)) {
            return false;
        }
        Guest guest = (Guest) o;
        return Objects.equals(id, guest.id) ;
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
            "}";
    }
    
}
