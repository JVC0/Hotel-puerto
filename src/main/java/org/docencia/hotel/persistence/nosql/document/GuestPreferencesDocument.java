package org.docencia.hotel.persistence.nosql.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Objects;

@Document(collection = "guest_preferences")
public class GuestPreferencesDocument {

    @Id
    private String id;
    @Field("guest_id")
    private String guestId;
    @Field("preferred_language")
    private String preferredLanguage;
    @Field("newsletter_opt_in")
    private boolean newsletterOptIn;
    @Field("favorite_room_type")
    private String favoriteRoomType;
    @Field("tags")
    private String[] tags;
    @Field("notes")
    private String notes;

    public GuestPreferencesDocument(String id) {
        this.id = id;
    }
    public GuestPreferencesDocument() {
    }

    public GuestPreferencesDocument(String id, String guestId, String preferredLanguage, boolean newsletterOptIn, String favoriteRoomType, String[] tags, String notes) {
        this.id = id;
        this.guestId = guestId;
        this.preferredLanguage = preferredLanguage;
        this.newsletterOptIn = newsletterOptIn;
        this.favoriteRoomType = favoriteRoomType;
        this.tags = tags;
        this.notes = notes;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGuestId() {
        return this.guestId;
    }

    public void setGuestId(String guestId) {
        this.guestId = guestId;
    }

    public String getPreferredLanguage() {
        return this.preferredLanguage;
    }

    public void setPreferredLanguage(String preferredLanguage) {
        this.preferredLanguage = preferredLanguage;
    }

    public boolean isNewsletterOptIn() {
        return this.newsletterOptIn;
    }

    public boolean getNewsletterOptIn() {
        return this.newsletterOptIn;
    }

    public void setNewsletterOptIn(boolean newsletterOptIn) {
        this.newsletterOptIn = newsletterOptIn;
    }

    public String getFavoriteRoomType() {
        return this.favoriteRoomType;
    }

    public void setFavoriteRoomType(String favoriteRoomType) {
        this.favoriteRoomType = favoriteRoomType;
    }

    public String[] getTags() {
        return this.tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof GuestPreferencesDocument)) {
            return false;
        }
        GuestPreferencesDocument guestPreferencesDocument = (GuestPreferencesDocument) o;
        return Objects.equals(id, guestPreferencesDocument.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", guestId='" + getGuestId() + "'" +
            ", preferredLanguage='" + getPreferredLanguage() + "'" +
            ", newsletterOptIn='" + isNewsletterOptIn() + "'" +
            ", favoriteRoomType='" + getFavoriteRoomType() + "'" +
            ", tags='" + getTags() + "'" +
            ", notes='" + getNotes() + "'" +
            "}";
    }
    
}
