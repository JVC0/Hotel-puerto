package org.docencia.hotel.service.impl;

import java.util.List;
import java.util.Optional;

import org.docencia.hotel.domain.model.Room;
import org.docencia.hotel.mapper.jpa.RoomMapper;
import org.docencia.hotel.persistence.jpa.entity.RoomEntity;
import org.docencia.hotel.persistence.repository.jpa.RoomRepository;
import org.docencia.hotel.service.api.RoomService;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl implements RoomService {
    private RoomRepository roomRepository;
    private RoomMapper roomMapper;
    public RoomServiceImpl(RoomRepository roomRepository, RoomMapper roomMapper) {
        this.roomRepository = roomRepository;
        this.roomMapper = roomMapper;
    }
    @Override
    public Optional<Room> findById(String roomId) {
        if (roomId == null) {
            return Optional.empty();
        }
        return Optional.of(roomMapper.toDomain(roomRepository.findById(roomId).get()));
    }

    @Override
    public List<Room> findAll() {
        return roomMapper.toDomainList(roomRepository.findAll());
    }

    @Override
    public Room save(Room room) {
        RoomEntity roomEntity = roomMapper.toEntity(room);
        RoomEntity savedEntity = roomRepository.save(roomEntity);
        return roomMapper.toDomain(savedEntity);
    }

    @Override
    public boolean deleteById(String roomId) {
        if (roomId == null) {
            return false;
        }
        roomRepository.deleteById(roomId);
        return true;
    }
}
