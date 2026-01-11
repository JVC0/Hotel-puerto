package org.docencia.hotel.mapper.jpa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.processing.Generated;
import org.docencia.hotel.domain.model.Guest;
import org.docencia.hotel.domain.model.GuestPreferences;
import org.docencia.hotel.persistence.jpa.entity.GuestEntity;
import org.docencia.hotel.persistence.nosql.document.GuestPreferencesDocument;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-11T02:54:41+0000",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.45.0.v20260106-1640, environment: Java 21.0.9 (Eclipse Adoptium)"
)
@Component
public class GuestMapperImpl implements GuestMapper {

    @Override
    public Guest toDomain(GuestEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Guest guest = new Guest();

        guest.setId( entity.getId() );
        guest.setFull_name( entity.getFull_name() );
        guest.setEmail( entity.getEmail() );
        guest.setPhone( entity.getPhone() );

        return guest;
    }

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

        return guestEntity;
    }

    @Override
    public List<Guest> toDomainList(List<GuestEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<Guest> list = new ArrayList<Guest>( entities.size() );
        for ( GuestEntity guestEntity : entities ) {
            list.add( toDomain( guestEntity ) );
        }

        return list;
    }

    @Override
    public Guest toDomain(GuestEntity entity, GuestPreferencesDocument preferences) {
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
        guest.setPreferences( guestPreferencesDocumentToGuestPreferences( preferences ) );

        return guest;
    }

    protected GuestPreferences guestPreferencesDocumentToGuestPreferences(GuestPreferencesDocument guestPreferencesDocument) {
        if ( guestPreferencesDocument == null ) {
            return null;
        }

        GuestPreferences guestPreferences = new GuestPreferences();

        guestPreferences.setId( guestPreferencesDocument.getId() );
        guestPreferences.setGuestId( guestPreferencesDocument.getGuestId() );
        guestPreferences.setPreferredLanguage( guestPreferencesDocument.getPreferredLanguage() );
        guestPreferences.setNewsletterOptIn( guestPreferencesDocument.getNewsletterOptIn() );
        guestPreferences.setFavoriteRoomType( guestPreferencesDocument.getFavoriteRoomType() );
        String[] tags = guestPreferencesDocument.getTags();
        if ( tags != null ) {
            guestPreferences.setTags( Arrays.copyOf( tags, tags.length ) );
        }
        guestPreferences.setNotes( guestPreferencesDocument.getNotes() );

        return guestPreferences;
    }
}
