package org.docencia.hotel.mapper.jpa;

import javax.annotation.processing.Generated;
import org.docencia.hotel.domain.model.Booking;
import org.docencia.hotel.persistence.jpa.entity.BookingEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-09T19:38:58+0000",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 25 (Eclipse Adoptium)"
)
@Component
public class BookingMapperImpl implements BookingMapper {

    @Autowired
    private RoomMapper roomMapper;
    @Autowired
    private GuestMapper guestMapper;

    @Override
    public BookingEntity toEntity(Booking domain) {
        if ( domain == null ) {
            return null;
        }

        BookingEntity bookingEntity = new BookingEntity();

        bookingEntity.setId( domain.getId() );
        bookingEntity.setRoom( roomMapper.toEntity( domain.getRoom() ) );
        bookingEntity.setGuest( guestMapper.toEntity( domain.getGuest() ) );
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
        booking.setRoom( roomMapper.toDomain( entity.getRoom() ) );
        booking.setGuest( guestMapper.toDomain( entity.getGuest() ) );
        booking.setCheck_in( entity.getCheck_in() );
        booking.setCheck_out( entity.getCheck_out() );

        return booking;
    }
}
