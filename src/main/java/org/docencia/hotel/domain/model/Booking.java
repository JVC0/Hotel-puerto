package org.docencia.hotel.domain.model;

import java.util.Objects;

public class Booking {
    private String id;
    private String roomId;
    private String guestId;
    private String check_in;
    private String check_out;

    public Booking(String id) {
        this.id = id;
    }

    public Booking() {
    }

    public Booking(String id, String roomId, String guestId, String check_in, String check_out) {
        this.id = id;
        this.roomId = roomId;
        this.guestId = guestId;
        this.check_in = check_in;
        this.check_out = check_out;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoomId() {
        return this.roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getGuestId() {
        return this.guestId;
    }

    public void setGuestId(String guestId) {
        this.guestId = guestId;
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
                ", roomId='" + getRoomId() + "'" +
                ", guestId='" + getGuestId() + "'" +
                ", check_in='" + getCheck_in() + "'" +
                ", check_out='" + getCheck_out() + "'" +
                "}";
    }

}
