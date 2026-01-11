package org.docencia.hotel.mapper.jpa;

import org.mapstruct.Mapper;

import java.util.List;

import org.docencia.hotel.domain.model.Hotel;
import org.docencia.hotel.persistence.jpa.entity.HotelEntity;

@Mapper(componentModel = "spring")
public interface HotelMapper {

    Hotel toDomain(HotelEntity entity);

    HotelEntity toEntity(Hotel domain);

    List<Hotel> toDomainList(List<HotelEntity> entities);
}
