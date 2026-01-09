package org.docencia.hotel.domain.api;

import java.util.*;

import org.docencia.hotel.domain.model.Hotel;

public interface HotelDomain {
    Optional<Hotel> findById(String id);
    List<Hotel> findAll();
    Hotel save(Hotel hotel);
    boolean deleteById(String hotelId);
}
