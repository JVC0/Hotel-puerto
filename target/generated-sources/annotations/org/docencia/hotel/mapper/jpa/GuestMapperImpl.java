package org.docencia.hotel.mapper.jpa;

import javax.annotation.processing.Generated;
import org.docencia.hotel.domain.model.Guest;
import org.docencia.hotel.domain.model.GuestPreferences;
import org.docencia.hotel.persistence.jpa.entity.GuestEntity;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-09T19:38:58+0000",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 25 (Eclipse Adoptium)"
)
@Component
public class GuestMapperImpl implements GuestMapper {

    @Override
    public GuestEntity toEntity(Guest domain) {
        if ( domain == null ) {
            return null;
        }

        GuestEntity guestEntity = new GuestEntity();

        guestEntity.setId( domain.getId() );
        guestEntity.setFull_name( domain.getFull_name() );
        guestEntity.setEmail( domain.getEmail() );
        guestEntity.setPhone( domain.getPhone() );
        guestEntity.setPreferences( domain.getPreferences() );

        return guestEntity;
    }

    @Override
    public Guest toDomain(GuestEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Guest guest = new Guest();

        guest.setPreferences( entity.getPreferences() );
        guest.setId( entity.getId() );
        guest.setFull_name( entity.getFull_name() );
        guest.setEmail( entity.getEmail() );
        guest.setPhone( entity.getPhone() );

        return guest;
    }

    @Override
    public Guest toDomain(GuestEntity entity, GuestPreferences preferences) {
        if ( entity == null && preferences == null ) {
            return null;
        }

        Guest guest = new Guest();

        if ( entity != null ) {
            guest.setId( entity.getId() );
            guest.setFull_name( entity.getFull_name() );
            guest.setEmail( entity.getEmail() );
            guest.setPhone( entity.getPhone() );
        }
        guest.setPreferences( preferences );

        return guest;
    }
}
