package org.docencia.hotel.service.impl;

import java.util.*;

import org.docencia.hotel.domain.model.Booking;
import org.docencia.hotel.mapper.jpa.BookingMapper;
import org.docencia.hotel.persistence.jpa.entity.BookingEntity;
import org.docencia.hotel.persistence.jpa.entity.GuestEntity;
import org.docencia.hotel.persistence.jpa.entity.RoomEntity;
import org.docencia.hotel.persistence.repository.jpa.BookingRepository;
import org.docencia.hotel.persistence.repository.jpa.GuestRepository;
import org.docencia.hotel.persistence.repository.jpa.RoomRepository;
import org.docencia.hotel.service.api.BookingService;
import org.springframework.stereotype.Service;



@Service
public class BookingServiceImpl implements BookingService {
    private BookingRepository bookingRepository;
    private BookingMapper bookingMapper;
    private RoomRepository roomRepository;
    private GuestRepository guestRepository;


    public BookingServiceImpl(BookingRepository bookingRepository, BookingMapper bookingMapper, RoomRepository roomRepository, GuestRepository guestRepository) {
        this.bookingRepository = bookingRepository;
        this.bookingMapper = bookingMapper;
        this.roomRepository = roomRepository;
        this.guestRepository = guestRepository;
    }

    @Override
    public Optional<Booking> findById(String bookingId) {
        if (bookingId == null) {
            return Optional.empty();
        }
        BookingEntity booking = bookingRepository.findById(bookingId).get();
        return Optional.of(bookingMapper.toDomain(booking));
    }

    @Override
    public List<Booking> findAll() {
        return bookingMapper.toDomainList(bookingRepository.findAll());
    }

    @Override
    public Booking save(Booking booking) {

        BookingEntity bookingEntity = bookingMapper.toEntity(booking);
        
        RoomEntity room = roomRepository.findById(booking.getRoomId()).orElse(null);
        bookingEntity.setRoom(room);

        GuestEntity guest = guestRepository.findById(booking.getGuestId()).orElse(null);
        bookingEntity.setGuest(guest);
        

        BookingEntity savedEntity = bookingRepository.save(bookingEntity);
        return bookingMapper.toDomain(savedEntity);
    }

    @Override
    public boolean deleteById(String bookingId) {
        if (bookingId != null) {
            bookingRepository.deleteById(bookingId);
            return true;
        }
        return false;
    }

}
