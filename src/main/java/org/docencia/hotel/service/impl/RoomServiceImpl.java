package org.docencia.hotel.service.impl;

import java.util.List;
import java.util.Optional;

import org.docencia.hotel.domain.model.Room;
import org.docencia.hotel.mapper.jpa.HotelMapper;
import org.docencia.hotel.mapper.jpa.RoomMapper;
import org.docencia.hotel.persistence.jpa.entity.HotelEntity;
import org.docencia.hotel.persistence.jpa.entity.RoomEntity;
import org.docencia.hotel.persistence.repository.jpa.HotelRepository;
import org.docencia.hotel.persistence.repository.jpa.RoomRepository;
import org.docencia.hotel.service.api.RoomService;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl implements RoomService {
    private final RoomRepository roomRepository;
    private final RoomMapper roomMapper;
    private final HotelRepository hotelRepository;
    private final HotelMapper hotelMapper;

    public RoomServiceImpl(RoomRepository roomRepository, 
            RoomMapper roomMapper,
            HotelRepository hotelRepository,
            HotelMapper hotelMapper) {
        this.roomRepository = roomRepository;
        this.roomMapper = roomMapper;
        this.hotelRepository = hotelRepository;
        this.hotelMapper = hotelMapper;
    }

    @Override
    public Optional<Room> findById(String roomId) {
        Optional<RoomEntity> roomEntityOpt = roomRepository.findById(roomId);
        return Optional.of(roomMapper.toDomain(roomEntityOpt.get()));
    }

    @Override
    public List<Room> findAll() {
        return roomMapper.toDomainList(roomRepository.findAll());
    }

    @Override
    public Room save(Room room) {
        if (room == null) {
            return null;
        }

        if (room.getHotel() == null) {
            return null;
        }

        HotelEntity hotelEntity = hotelMapper.toEntity(room.getHotel());
        hotelEntity = hotelRepository.findById(room.getHotel().getId()).orElse(hotelEntity);
        hotelEntity = hotelRepository.save(hotelEntity);

        RoomEntity roomEntity = roomMapper.toEntity(room);
        roomEntity = roomRepository.findById(room.getId()).orElse(roomEntity);
        roomEntity.setHotel(hotelEntity);
        RoomEntity savedEntity = roomRepository.save(roomEntity);
        
        return roomMapper.toDomain(savedEntity);
    }

    @Override
    public boolean deleteById(String roomId) {
        if (roomId != null && !roomId.trim().isEmpty()) {
            roomRepository.deleteById(roomId);
            return true;
        }
        return false;
    }
}