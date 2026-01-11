package org.docencia.hotel.domain.model;

import java.util.Objects;

public class Booking {
    private String id;
    private Room room;
    private Guest guest;
    private String checkIn;
    private String checkOut;

    public Booking(String id) {
        this.id = id;
    }

    public Booking() {
    }

    public Booking(String id, Room room, Guest guest, String checkIn, String checkOut) {
        this.id = id;
        this.room = room;
        this.guest = guest;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
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

    public String getCheckIn() {
        return this.checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return this.checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
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
                ", checkIn='" + getCheckIn() + "'" +
                ", checkOut='" + getCheckOut() + "'" +
                "}";
    }
}