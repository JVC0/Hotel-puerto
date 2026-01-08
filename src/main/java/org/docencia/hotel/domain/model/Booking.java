package org.docencia.hotel.domain.model;
import java.util.Objects;





public class Booking {
    private String id;
    private Room room;
    private Guest guest;
    private String check_in;
    private String check_out;

    public Booking(String id) {
        this.id = id;
    }
    public Booking() {
    }

    public Booking(String id, Room room, Guest guest, String check_in, String check_out) {
        this.id = id;
        this.room = room;
        this.guest = guest;
        this.check_in = check_in;
        this.check_out = check_out;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Room getRoom() {
        return this.room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Guest getGuest() {
        return this.guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
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
        return Objects.equals(id, booking.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", room='" + getRoom() + "'" +
            ", guest='" + getGuest() + "'" +
            ", check_in='" + getCheck_in() + "'" +
            ", check_out='" + getCheck_out() + "'" +
            "}";
    }


  
    
}
