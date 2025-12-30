package org.docencia.hotel.persistence.repository.jpa;

import org.docencia.hotel.domain.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends  JpaRepository<Room, String>  {

}
