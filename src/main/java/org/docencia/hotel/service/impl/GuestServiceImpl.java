package org.docencia.hotel.service.impl;

import java.util.*;
import org.docencia.hotel.domain.model.Guest;
import org.docencia.hotel.mapper.jpa.GuestMapper;
import org.docencia.hotel.mapper.nosql.GuestPreferencesMapper;
import org.docencia.hotel.persistence.jpa.entity.GuestEntity;
import org.docencia.hotel.persistence.nosql.document.GuestPreferencesDocument;
import org.docencia.hotel.persistence.repository.jpa.GuestRepository;
import org.docencia.hotel.persistence.repository.nosql.GuestPreferencesRepository;
import org.docencia.hotel.service.api.GuestService;
import org.springframework.stereotype.Service;

@Service
public class GuestServiceImpl implements GuestService {

    private GuestPreferencesRepository guestPreferencesRepository;
    private GuestRepository guestRepository;
    private GuestMapper guestMapper;

    private GuestPreferencesMapper guestPreferencesMapper;

    public GuestServiceImpl(GuestRepository guestRepository, GuestMapper guestMapper,
            GuestPreferencesMapper guestPreferencesMapper, GuestPreferencesRepository guestPreferencesRepository) {
        this.guestRepository = guestRepository;
        this.guestMapper = guestMapper;
        this.guestPreferencesMapper = guestPreferencesMapper;
        this.guestPreferencesRepository = guestPreferencesRepository;
    }

    @Override
    public Optional<Guest> findById(String guestId) {
        if (guestId == null) {
            return Optional.empty();
        }
        GuestEntity guestEntity = guestRepository.findById(guestId).get();
        GuestPreferencesDocument preferencesDocument = guestPreferencesRepository.findByGuestId(guestId);
        return Optional.of(guestMapper.toDomain(guestEntity, preferencesDocument));
    }

    @Override
    public List<Guest> findAll() {
        List<GuestEntity> guestEntities = guestRepository.findAll();
        List<Guest> guests = new ArrayList<>();

        for (GuestEntity entity : guestEntities) {
            GuestPreferencesDocument preferencesDoc = guestPreferencesRepository.findByGuestId(entity.getId());
            Guest guest = guestMapper.toDomain(entity, preferencesDoc);
            guests.add(guest);
        }

        return guests;
    }

    @Override
    public Guest save(Guest guest) {
        GuestEntity guestEntity = guestMapper.toEntity(guest);
        GuestEntity savedEntity = guestRepository.save(guestEntity);
        if (guest.getPreferences() == null) {
            return guestMapper.toDomain(savedEntity);
        }
        GuestPreferencesDocument preferences = guestPreferencesMapper.toDocument(guest.getPreferences());
        preferences.setGuestId(savedEntity.getId());
        preferences = guestPreferencesRepository.save(preferences);
        return guestMapper.toDomain(savedEntity, preferences);
    }

    @Override
    public boolean deleteById(String guestId) {
        if (guestId == null) {
            return false;
        }
        guestPreferencesRepository.deleteByGuestId(guestId);
        guestRepository.deleteById(guestId);
        return true;
    }

}
