package org.docencia.hotel.service.api;

import java.util.*;

import org.docencia.hotel.domain.model.Guest;

public interface GuestService {
    Optional<Guest> findById(String guestId);

    List<Guest> findAll();

    Guest save(Guest guest);

    boolean deleteById(String guestId);
}
