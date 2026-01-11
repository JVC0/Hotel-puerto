package org.docencia.hotel.mapper.jpa;

import org.mapstruct.*;

import java.util.List;

import org.docencia.hotel.domain.model.Booking;
import org.docencia.hotel.persistence.jpa.entity.BookingEntity;

@Mapper(componentModel = "spring")
public interface BookingMapper {

    @Mapping(target = "roomId", source = "room.id")
    @Mapping(target = "guestId", source = "guest.id")
    Booking toDomain(BookingEntity entity);

    List<Booking> toDomainList(List<BookingEntity> entities);

    @Mapping(target = "room", ignore = true)
    @Mapping(target = "guest", ignore = true)
    BookingEntity toEntity(Booking domain);

}
