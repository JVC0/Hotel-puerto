package org.docencia.hotel.persistence.repository.nosql;

import org.docencia.hotel.persistence.nosql.document.GuestPreferencesDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestPreferencesRepository extends MongoRepository<GuestPreferencesDocument, String> {

    GuestPreferencesDocument findByGuestId(String guestId);

    void deleteByGuestId(String guestId);
}