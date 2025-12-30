package org.docencia.hotel.persistence.repository.jpa;

import org.docencia.hotel.domain.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends  JpaRepository<Booking, String>  {
}
