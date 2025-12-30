package org.docencia.hotel.persistence.repository.jpa;

import org.docencia.hotel.domain.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends  JpaRepository<Hotel, String>  {
}
