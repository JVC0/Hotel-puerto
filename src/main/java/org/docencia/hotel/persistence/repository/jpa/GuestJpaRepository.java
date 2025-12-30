package org.docencia.hotel.persistence.repository.jpa;

import org.docencia.hotel.domain.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestJpaRepository  extends  JpaRepository<Guest, String> {
}
