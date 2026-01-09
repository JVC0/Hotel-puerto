package org.docencia.hotel.domain.api;

import java.util.List;
import java.util.Optional;

import org.docencia.hotel.domain.model.Guest;

public interface GuestDomain {
    Optional<Guest> findById(String id);
    List<Guest> findAll();
    Guest save(Guest guest);
    boolean deleteById(String guestId);
}
