package org.docencia.hotel.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    @Override
    public Optional<Hotel> findById(String id) {
        HotelEntity hotel= hotelRepository.findById(id).get();
        return Optional.of(hotelMapper.toDomain(hotel));
    }

    @Override
    public List<Hotel> findAll() {
        List<HotelEntity> hotels= hotelRepository.findAll();
        List<Hotel> result = new ArrayList<>();
        for(HotelEntity hotel: hotels){
            hotelMapper.toDomain(hotel);
            result.add(hotelMapper.toDomain(hotel));
        }
        return result;
    }

    @Override
    public Hotel save(Hotel hotel) {
        HotelEntity hotelEntity = hotelMapper.toEntity(hotel);
        HotelEntity savedEntity = hotelRepository.save(hotelEntity);
        return hotelMapper.toDomain(savedEntity);
    }

    @Override
    public boolean deleteById(String hotelId) {
        if(hotelId!= null){
            hotelRepository.deleteById(hotelId);
            return true;
        }
        return false    ;
    }
    // TODO: inyectar repositorios + mappers y aplicar lógica
}
