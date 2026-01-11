package org.docencia.hotel.persistence.jpa.entity;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "booking")
public class BookingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    
    @OneToOne
    @JoinColumn(name = "room_id", nullable = false)
    private RoomEntity room;
    
    @OneToOne
    @JoinColumn(name = "guest_id", nullable = false)
    private GuestEntity guest;
    
    @Column(name = "check_in")
    private String checkIn;
    
    @Column(name = "check_out")
    private String checkOut;

    public BookingEntity(String id) {
        this.id = id;
    }

    public BookingEntity() {
    }

    public BookingEntity(String id, RoomEntity room, GuestEntity guest, String checkIn, String checkOut) {
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

    public RoomEntity getRoom() {
        return this.room;
    }

    public void setRoom(RoomEntity room) {
        this.room = room;
    }

    public GuestEntity getGuest() {
        return this.guest;
    }

    public void setGuest(GuestEntity guest) {
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
        if (!(o instanceof BookingEntity)) {
            return false;
        }
        BookingEntity bookingEntity = (BookingEntity) o;
        return Objects.equals(id, bookingEntity.id);
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