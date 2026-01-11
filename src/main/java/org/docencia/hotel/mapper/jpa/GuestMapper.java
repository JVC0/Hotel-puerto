package org.docencia.hotel.mapper.jpa;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

import org.docencia.hotel.domain.model.Guest;
import org.docencia.hotel.persistence.jpa.entity.GuestEntity;
import org.docencia.hotel.persistence.nosql.document.GuestPreferencesDocument;

@Mapper(componentModel = "spring")
public interface GuestMapper {

    @Mapping(target = "preferences", ignore = true)
    Guest toDomain(GuestEntity entity);

    @Mapping(target = "booking", ignore = true)
    @Mapping(target = "preferences", ignore = true)
    GuestEntity toEntity(Guest domain);

    List<Guest> toDomainList(List<GuestEntity> entities);

    @Mapping(target = "id", source = "entity.id")
    @Mapping(target = "preferences", source = "preferences")
    Guest toDomain(GuestEntity entity, GuestPreferencesDocument preferences);
}
