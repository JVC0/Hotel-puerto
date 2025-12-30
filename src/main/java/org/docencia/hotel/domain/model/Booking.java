package org.docencia.hotel.domain.model;
import java.util.Objects;

public class Booking {
    private String id;
    private String room_id;
    private String guest_id;
    private String check_in;
    private String check_out;

    public Booking(String id) {
        this.id = id;
    }
    public Booking() {
    }

    public Booking(String id, String room_id, String guest_id, String check_in, String check_out) {
        this.id = id;
        this.room_id = room_id;
        this.guest_id = guest_id;
        this.check_in = check_in;
        this.check_out = check_out;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoom_id() {
        return this.room_id;
    }

    public void setRoom_id(String room_id) {
        this.room_id = room_id;
    }

    public String getGuest_id() {
        return this.guest_id;
    }

    public void setGuest_id(String guest_id) {
        this.guest_id = guest_id;
    }

    public String getCheck_in() {
        return this.check_in;
    }

    public void setCheck_in(String check_in) {
        this.check_in = check_in;
    }

    public String getCheck_out() {
        return this.check_out;
    }

    public void setCheck_out(String check_out) {
        this.check_out = check_out;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Booking)) {
            return false;
        }
        Booking booking = (Booking) o;
        return Objects.equals(id, booking.id) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", room_id='" + getRoom_id() + "'" +
            ", guest_id='" + getGuest_id() + "'" +
            ", check_in='" + getCheck_in() + "'" +
            ", check_out='" + getCheck_out() + "'" +
            "}";
    }
    
}
