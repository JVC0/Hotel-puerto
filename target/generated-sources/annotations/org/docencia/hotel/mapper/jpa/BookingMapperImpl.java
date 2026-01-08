package org.docencia.hotel.mapper.jpa;

import javax.annotation.processing.Generated;
import org.docencia.hotel.domain.model.Booking;
import org.docencia.hotel.domain.model.Guest;
import org.docencia.hotel.domain.model.Hotel;
import org.docencia.hotel.domain.model.Room;
import org.docencia.hotel.persistence.jpa.entity.BookingEntity;
import org.docencia.hotel.persistence.jpa.entity.GuestEntity;
import org.docencia.hotel.persistence.jpa.entity.HotelEntity;
import org.docencia.hotel.persistence.jpa.entity.RoomEntity;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-07T18:38:37+0000",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 25 (Oracle Corporation)"
)
@Component
public class BookingMapperImpl implements BookingMapper {

    @Override
    public BookingEntity toEntity(Booking domain) {
        if ( domain == null ) {
            return null;
        }

        BookingEntity bookingEntity = new BookingEntity();

        bookingEntity.setId( domain.getId() );
        bookingEntity.setRoom( roomToRoomEntity( domain.getRoom() ) );
        bookingEntity.setGuest( guestToGuestEntity( domain.getGuest() ) );
        bookingEntity.setCheck_in( domain.getCheck_in() );
        bookingEntity.setCheck_out( domain.getCheck_out() );

        return bookingEntity;
    }

    @Override
    public Booking toDomain(BookingEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Booking booking = new Booking();

        booking.setId( entity.getId() );
        booking.setRoom( roomEntityToRoom( entity.getRoom() ) );
        booking.setGuest( guestEntityToGuest( entity.getGuest() ) );
        booking.setCheck_in( entity.getCheck_in() );
        booking.setCheck_out( entity.getCheck_out() );

        return booking;
    }

    protected HotelEntity hotelToHotelEntity(Hotel hotel) {
        if ( hotel == null ) {
            return null;
        }

        HotelEntity hotelEntity = new HotelEntity();

        hotelEntity.setId( hotel.getId() );
        hotelEntity.setName( hotel.getName() );
        hotelEntity.setAddress( hotel.getAddress() );

        return hotelEntity;
    }

    protected RoomEntity roomToRoomEntity(Room room) {
        if ( room == null ) {
            return null;
        }

        RoomEntity roomEntity = new RoomEntity();

        roomEntity.id( room.getId() );
        roomEntity.setNumber( room.getNumber() );
        roomEntity.setType( room.getType() );
        roomEntity.setPrice_per_night( room.getPrice_per_night() );
        roomEntity.setHotel( hotelToHotelEntity( room.getHotel() ) );

        return roomEntity;
    }

    protected GuestEntity guestToGuestEntity(Guest guest) {
        if ( guest == null ) {
            return null;
        }

        GuestEntity guestEntity = new GuestEntity();

        guestEntity.setId( guest.getId() );
        guestEntity.setFull_name( guest.getFull_name() );
        guestEntity.setEmail( guest.getEmail() );
        guestEntity.setPhone( guest.getPhone() );

        return guestEntity;
    }

    protected Hotel hotelEntityToHotel(HotelEntity hotelEntity) {
        if ( hotelEntity == null ) {
            return null;
        }

        Hotel hotel = new Hotel();

        hotel.setId( hotelEntity.getId() );
        hotel.setName( hotelEntity.getName() );
        hotel.setAddress( hotelEntity.getAddress() );

        return hotel;
    }

    protected Room roomEntityToRoom(RoomEntity roomEntity) {
        if ( roomEntity == null ) {
            return null;
        }

        Room room = new Room();

        room.setId( roomEntity.getId() );
        room.setNumber( roomEntity.getNumber() );
        room.setType( roomEntity.getType() );
        room.setPrice_per_night( roomEntity.getPrice_per_night() );
        room.setHotel( hotelEntityToHotel( roomEntity.getHotel() ) );

        return room;
    }

    protected Guest guestEntityToGuest(GuestEntity guestEntity) {
        if ( guestEntity == null ) {
            return null;
        }

        Guest guest = new Guest();

        guest.setId( guestEntity.getId() );
        guest.setFull_name( guestEntity.getFull_name() );
        guest.setEmail( guestEntity.getEmail() );
        guest.setPhone( guestEntity.getPhone() );

        return guest;
    }
}
