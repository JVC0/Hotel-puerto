package org.docencia.hotel.domain.impl;

import java.util.List;
import java.util.Optional;

import org.apache.xml.resolver.apps.resolver;
import org.docencia.hotel.domain.api.RoomDomain;
import org.docencia.hotel.domain.model.Room;
import org.docencia.hotel.service.api.RoomService;
import org.springframework.stereotype.Service;

@Service
public class RoomDomainImpl implements RoomDomain {

    private final RoomService service;

    public RoomDomainImpl(RoomService service) {
        this.service = service;
    }

    @Override
    public Optional<Room> findById(String id) {
        return service.findById(id);
    }

    @Override
    public List<Room> findAll() {
        return service.findAll();
    }

    @Override
    public Room save(Room room) {
        return service.save(room);
    }

    @Override
    public boolean deleteById(String roomId) {
        return service.deleteById(roomId);
    }

}
