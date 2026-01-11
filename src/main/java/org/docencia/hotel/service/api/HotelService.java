package org.docencia.hotel.service.api;

import java.util.*;

import org.docencia.hotel.domain.model.Hotel;

public interface HotelService {
    Optional<Hotel> findById(String hotelId);

    List<Hotel> findAll();

    Hotel save(Hotel hotel);

    boolean deleteById(String hotelId);
}
