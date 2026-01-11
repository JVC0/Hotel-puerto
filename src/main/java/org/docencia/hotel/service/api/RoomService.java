package org.docencia.hotel.service.api;

import java.util.*;

import org.docencia.hotel.domain.model.Room;

public interface RoomService {
    Optional<Room> findById(String roomId);

    List<Room> findAll();

    Room save(Room room);

    boolean deleteById(String roomId);
}
