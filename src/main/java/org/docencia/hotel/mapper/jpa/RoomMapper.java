package org.docencia.hotel.mapper.jpa;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

import org.docencia.hotel.domain.model.Room;
import org.docencia.hotel.persistence.jpa.entity.RoomEntity;

@Mapper(componentModel = "spring")
public interface RoomMapper {
    @Mapping(target = "hotelId", ignore = true)
    Room toDomain(RoomEntity entity);

    @Mapping(target = "hotel", ignore = true)
    RoomEntity toEntity(Room domain);

    List<Room> toDomainList(List<RoomEntity> entities);
}
