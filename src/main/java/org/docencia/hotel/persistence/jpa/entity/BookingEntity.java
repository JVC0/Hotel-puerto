package org.docencia.hotel.persistence.jpa.entity;

import org.docencia.hotel.domain.model.Guest;
import org.docencia.hotel.domain.model.Room;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "booking")
public class BookingEntity {
    @Id
    private String id;
    @OneToOne
    @JoinColumn(name = "room_id",nullable = false)
    private RoomEntity room;
    @OneToOne
    @JoinColumn(name = "guest_id",nullable = false)
    private GuestEntity guest;
    @Column(name="check_in")
    private String check_in;
    @Column(name="check_out")
    private String check_out;

    public BookingEntity(String id) {
        this.id = id;   
    }
    public BookingEntity() {
    }


    public BookingEntity(String id, RoomEntity room, GuestEntity guest, String check_in, String check_out) {
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
            ", check_in='" + getCheck_in() + "'" +
            ", check_out='" + getCheck_out() + "'" +
            "}";
    }
    
}
