package org.docencia.hotel.domain.api;

import java.util.*;

import org.docencia.hotel.domain.model.Room;

public interface RoomDomain {
    Optional<Room> findById(String id);
    List<Room> findAll();
    Room save(Room room);
    boolean deleteById(String roomId);
}
