package org.docencia.hotel.mapper.nosql;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.docencia.hotel.domain.model.GuestPreferences;
import org.docencia.hotel.persistence.nosql.document.GuestPreferencesDocument;

@Mapper(componentModel = "spring")
public interface GuestPreferencesMapper {
    @Mapping(target = "id", ignore = true)  
    GuestPreferencesDocument toDocument(GuestPreferences preferences);
    
    GuestPreferences toDomain(GuestPreferencesDocument document);
}
