package org.docencia.hotel.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.docencia.hotel.domain.model.Room;
import org.docencia.hotel.mapper.jpa.RoomMapper;
import org.docencia.hotel.persistence.jpa.entity.HotelEntity;
import org.docencia.hotel.persistence.jpa.entity.RoomEntity;
import org.docencia.hotel.persistence.repository.jpa.RoomRepository;
import org.docencia.hotel.service.api.RoomService;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl implements RoomService {
    private RoomRepository roomRepository;
    private RoomMapper roomMapper;
    @Override
    public Optional<Room> findById(String id) {
        RoomEntity room  = roomRepository.findById(id).get();
        return Optional.of(roomMapper.toDomain(room));

    }

    @Override
    public List<Room> findAll() {
        List<RoomEntity> rooms= roomRepository.findAll();
        List<Room> result = new ArrayList<>();
        for(RoomEntity room: rooms){
            roomMapper.toDomain(room);
            result.add(roomMapper.toDomain(room));
        }
        return result;
    }

    @Override
    public Room save(Room room) {
        RoomEntity roomEntity = roomMapper.toEntity(room);
        RoomEntity savedEntity = roomRepository.save(roomEntity);
        return roomMapper.toDomain(savedEntity);
    }

    @Override
    public boolean deleteById(String roomId) {
        if(roomId!= null){
            roomRepository.deleteById(roomId);
            return true;
        }
        return false    ;
    }
    // TODO: inyectar repositorios + mappers y aplicar lógica
}
