package org.docencia.hotel.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.docencia.hotel.domain.model.Guest;
import org.docencia.hotel.mapper.jpa.GuestMapper;
import org.docencia.hotel.persistence.jpa.entity.GuestEntity;
import org.docencia.hotel.persistence.repository.jpa.GuestRepository;
import org.docencia.hotel.service.api.GuestService;
import org.springframework.stereotype.Service;

@Service
public class GuestServiceImpl implements GuestService {
    private GuestRepository guestRepository;
    private GuestMapper guestMapper;
    
    public GuestServiceImpl(GuestRepository guestRepository, GuestMapper guestMapper) {
        this.guestRepository = guestRepository;
        this.guestMapper = guestMapper;
    }

    @Override
    public Optional<Guest> findById(String id) {
        GuestEntity guest= guestRepository.findById(id).get();
        return Optional.of(guestMapper.toDomain(guest));
    }

    @Override
    public List<Guest> findAll() {
        List<GuestEntity> guests= guestRepository.findAll();
        List<Guest> result = new ArrayList<>();
        for(GuestEntity guest: guests){
            guestMapper.toDomain(guest);
            result.add(guestMapper.toDomain(guest));
        }
        return result;
    }

    @Override
    public Guest save(Guest guest) {
        GuestEntity guestEntity = guestMapper.toEntity(guest);
        GuestEntity savedEntity = guestRepository.save(guestEntity);
        return guestMapper.toDomain(savedEntity);
    }

    @Override
    public boolean deleteById(String guestId) {
        if(guestId!= null){
            guestRepository.deleteById(guestId);
            return true;
        }
        return false    ;
    }

    // TODO: inyectar repositorios + mappers y aplicar lógica
}
