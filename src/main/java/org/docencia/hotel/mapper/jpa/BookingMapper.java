package org.docencia.hotel.mapper.jpa;

import org.mapstruct.*;

import java.util.List;

import org.docencia.hotel.domain.model.Booking;
import org.docencia.hotel.persistence.jpa.entity.BookingEntity;

@Mapper(componentModel = "spring", uses = { RoomMapper.class, GuestMapper.class })
public interface BookingMapper {

    Booking toDomain(BookingEntity entity);

    List<Booking> toDomainList(List<BookingEntity> entities);

    @Mapping(target = "room", ignore = true)
    @Mapping(target = "guest", ignore = true)
    BookingEntity toEntity(Booking domain);
}
