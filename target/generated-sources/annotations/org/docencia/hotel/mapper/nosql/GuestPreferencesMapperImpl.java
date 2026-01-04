package org.docencia.hotel.mapper.nosql;

import java.util.Arrays;
import javax.annotation.processing.Generated;
import org.docencia.hotel.domain.model.GuestPreferences;
import org.docencia.hotel.persistence.nosql.document.GuestPreferencesDocument;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-04T13:24:48+0000",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 25 (Oracle Corporation)"
)
@Component
public class GuestPreferencesMapperImpl implements GuestPreferencesMapper {

    @Override
    public GuestPreferencesDocument toDocument(GuestPreferences domain) {
        if ( domain == null ) {
            return null;
        }

        GuestPreferencesDocument guestPreferencesDocument = new GuestPreferencesDocument();

        guestPreferencesDocument.setId( domain.getId() );
        guestPreferencesDocument.setGuestId( domain.getGuestId() );
        guestPreferencesDocument.setPreferredLanguage( domain.getPreferredLanguage() );
        guestPreferencesDocument.setNewsletterOptIn( domain.getNewsletterOptIn() );
        guestPreferencesDocument.setFavoriteRoomType( domain.getFavoriteRoomType() );
        String[] tags = domain.getTags();
        if ( tags != null ) {
            guestPreferencesDocument.setTags( Arrays.copyOf( tags, tags.length ) );
        }
        guestPreferencesDocument.setNotes( domain.getNotes() );

        return guestPreferencesDocument;
    }

    @Override
    public GuestPreferences toDomain(GuestPreferencesDocument doc) {
        if ( doc == null ) {
            return null;
        }

        GuestPreferences guestPreferences = new GuestPreferences();

        guestPreferences.setId( doc.getId() );
        guestPreferences.setGuestId( doc.getGuestId() );
        guestPreferences.setPreferredLanguage( doc.getPreferredLanguage() );
        guestPreferences.setNewsletterOptIn( doc.getNewsletterOptIn() );
        guestPreferences.setFavoriteRoomType( doc.getFavoriteRoomType() );
        String[] tags = doc.getTags();
        if ( tags != null ) {
            guestPreferences.setTags( Arrays.copyOf( tags, tags.length ) );
        }
        guestPreferences.setNotes( doc.getNotes() );

        return guestPreferences;
    }
}
