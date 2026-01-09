package org.docencia.hotel.mapper.jpa;

import org.mapstruct.Mapper;
import org.docencia.hotel.domain.model.Booking;
import org.docencia.hotel.persistence.jpa.entity.BookingEntity;

@Mapper(componentModel = "spring", uses = { RoomMapper.class, GuestMapper.class })
public interface BookingMapper {
    
    BookingEntity toEntity(Booking domain);

    Booking toDomain(BookingEntity entity);
}
