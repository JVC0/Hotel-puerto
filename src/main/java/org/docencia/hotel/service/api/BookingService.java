package org.docencia.hotel.service.api;

import java.util.List;
import java.util.Optional;

import org.docencia.hotel.domain.model.Booking;




public interface BookingService {
    Optional<Booking> findById(String id);
    List<Booking> findAll();
    Booking save(Booking booking);
    boolean deleteById(String bookingId);
    
}
