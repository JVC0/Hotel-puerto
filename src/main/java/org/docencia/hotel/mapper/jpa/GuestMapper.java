package org.docencia.hotel.mapper.jpa;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

import org.docencia.hotel.domain.model.Guest;
import org.docencia.hotel.mapper.nosql.GuestPreferencesMapper;
import org.docencia.hotel.persistence.jpa.entity.GuestEntity;
import org.docencia.hotel.persistence.nosql.document.GuestPreferencesDocument;

@Mapper(componentModel = "spring", uses = { GuestPreferencesMapper.class })
public interface GuestMapper {

    
    Guest toDomain(GuestEntity entity);

    @Mapping(target = "booking", ignore = true)
    GuestEntity toEntity(Guest domain);

    @Mapping(target = "id", source = "entity.id")
    @Mapping(target = "preferences", source = "preferencesDocument")
    Guest toDomain(GuestEntity entity, GuestPreferencesDocument preferencesDocument);
    
    List<Guest> toDomainList(List<GuestEntity> entities);
}
