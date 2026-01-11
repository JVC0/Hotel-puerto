package org.docencia.hotel.domain.impl;

import java.util.*;
import org.docencia.hotel.domain.api.GuestDomain;
import org.docencia.hotel.domain.model.Guest;
import org.docencia.hotel.service.api.GuestService;
import org.springframework.stereotype.Service;

@Service
public class GuestDomainImpl implements GuestDomain {

    private final GuestService service;

    public GuestDomainImpl(GuestService service) {
        this.service = service;
    }

    @Override
    public Optional<Guest> findById(String id) {
        return service.findById(id);
    }

    @Override
    public List<Guest> findAll() {
        return service.findAll();
    }

    @Override
    public Guest save(Guest guest) {
        return service.save(guest);
    }

    @Override
    public boolean deleteById(String guestId) {
        return service.deleteById(guestId);
    }

}
