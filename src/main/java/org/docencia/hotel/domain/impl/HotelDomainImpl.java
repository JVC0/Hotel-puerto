package org.docencia.hotel.domain.impl;

import java.util.List;
import java.util.Optional;

import org.docencia.hotel.domain.api.HotelDomain;
import org.docencia.hotel.domain.model.Hotel;
import org.docencia.hotel.service.api.HotelService;
import org.springframework.stereotype.Service;

@Service
public class HotelDomainImpl implements HotelDomain {

    private final HotelService service;

    public HotelDomainImpl(HotelService service) {
        this.service = service;
    }

    @Override
    public Optional<Hotel> findById(String id) {
        return service.findById(id);
    }

    @Override
    public List<Hotel> findAll() {
        return service.findAll();
    }

    @Override
    public Hotel save(Hotel hotel) {
        return service.save(hotel);
    }

    @Override
    public boolean deleteById(String hotelId) {
        return service.deleteById(hotelId);
    }

}
