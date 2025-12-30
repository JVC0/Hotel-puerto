package org.docencia.hotel.mapper.jpa;

import javax.annotation.processing.Generated;
import org.docencia.hotel.domain.model.Booking;
import org.docencia.hotel.persistence.jpa.entity.BookingEntity;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-22T13:00:08+0100",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.45.0.v20251218-1032, environment: Java 21.0.9 (Eclipse Adoptium)"
)
@Component
public class BookingMapperImpl implements BookingMapper {

    @Override
    public BookingEntity toEntity(Booking domain) {
        if ( domain == null ) {
            return null;
        }

        BookingEntity bookingEntity = new BookingEntity();

        return bookingEntity;
    }

    @Override
    public Booking toDomain(BookingEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Booking booking = new Booking();

        return booking;
    }
}
