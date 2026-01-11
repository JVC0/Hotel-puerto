package org.docencia.hotel.service.impl;

import java.util.*;
import org.docencia.hotel.domain.model.Hotel;
import org.docencia.hotel.mapper.jpa.HotelMapper;
import org.docencia.hotel.persistence.jpa.entity.HotelEntity;
import org.docencia.hotel.persistence.repository.jpa.HotelRepository;
import org.docencia.hotel.service.api.HotelService;
import org.springframework.stereotype.Service;

@Service
public class HotelServiceImpl implements HotelService {
    private HotelRepository hotelRepository;
    private HotelMapper hotelMapper;

    public HotelServiceImpl(HotelRepository hotelRepository, HotelMapper hotelMapper) {
        this.hotelRepository = hotelRepository;
        this.hotelMapper = hotelMapper;
    }

    @Override
    public Optional<Hotel> findById(String hotelId) {
        if (hotelId == null) {
            return Optional.empty();
        }
        return Optional.of(hotelMapper.toDomain(hotelRepository.findById(hotelId).get()));
    }

    @Override
    public List<Hotel> findAll() {
        return hotelMapper.toDomainList(hotelRepository.findAll());
    }

    @Override
    public Hotel save(Hotel hotel) {
        HotelEntity hotelEntity = hotelMapper.toEntity(hotel);
        HotelEntity savedEntity = hotelRepository.save(hotelEntity);
        return hotelMapper.toDomain(savedEntity);
    }

    @Override
    public boolean deleteById(String hotelId) {
        if (hotelId == null) {
            return false;
        }
        hotelRepository.deleteById(hotelId);
        return true;
    }

}
