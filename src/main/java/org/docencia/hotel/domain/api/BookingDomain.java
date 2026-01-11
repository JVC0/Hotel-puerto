package org.docencia.hotel.domain.api;

import java.util.*;

import org.docencia.hotel.domain.model.Booking;

public interface BookingDomain {
    Optional<Booking> findById(String id);

    List<Booking> findAll();

    Booking save(Booking booking);

    boolean deleteById(String bookingId);
}
