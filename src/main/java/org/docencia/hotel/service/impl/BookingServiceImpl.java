package org.docencia.hotel.service.impl;

import java.util.*;

import org.docencia.hotel.domain.model.Booking;
import org.docencia.hotel.mapper.jpa.BookingMapper;
import org.docencia.hotel.mapper.jpa.GuestMapper;
import org.docencia.hotel.mapper.jpa.HotelMapper;
import org.docencia.hotel.mapper.jpa.RoomMapper;
import org.docencia.hotel.persistence.jpa.entity.BookingEntity;
import org.docencia.hotel.persistence.jpa.entity.GuestEntity;
import org.docencia.hotel.persistence.jpa.entity.HotelEntity;
import org.docencia.hotel.persistence.jpa.entity.RoomEntity;
import org.docencia.hotel.persistence.repository.jpa.BookingRepository;
import org.docencia.hotel.persistence.repository.jpa.GuestRepository;
import org.docencia.hotel.persistence.repository.jpa.HotelRepository;
import org.docencia.hotel.persistence.repository.jpa.RoomRepository;
import org.docencia.hotel.service.api.BookingService;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;
    private final RoomRepository roomRepository;
    private final GuestRepository guestRepository;
    private final GuestMapper guestMapper;
    private final RoomMapper roomMapper;
    private final HotelRepository hotelRepository;
    private final HotelMapper hotelMapper;

    public BookingServiceImpl(BookingRepository bookingRepository,
            BookingMapper bookingMapper,
            RoomRepository roomRepository,
            GuestRepository guestRepository,
            GuestMapper guestMapper,
            RoomMapper roomMapper, HotelRepository hotelRepository, HotelMapper hotelMapper) {
        this.hotelRepository = hotelRepository;
        this.bookingRepository = bookingRepository;
        this.bookingMapper = bookingMapper;
        this.roomRepository = roomRepository;
        this.guestRepository = guestRepository;
        this.guestMapper = guestMapper;
        this.roomMapper = roomMapper;
        this.hotelMapper = hotelMapper;
    }

    @Override
    public Optional<Booking> findById(String bookingId) {
        if (bookingId == null || bookingId.trim().isEmpty()) {
            return Optional.empty();
        }

        Optional<BookingEntity> bookingEntityOpt = bookingRepository.findById(bookingId);
        if (bookingEntityOpt.isPresent()) {
            return Optional.of(bookingMapper.toDomain(bookingEntityOpt.get()));
        }
        return Optional.empty();
    }

    @Override
    public List<Booking> findAll() {
        return bookingMapper.toDomainList(bookingRepository.findAll());
    }

    @Override
    public Booking save(Booking booking) {
        HotelEntity hotelEntity = hotelMapper.toEntity(booking.getRoom().getHotel());
        hotelEntity = hotelRepository.findById(booking.getRoom().getHotel().getId()).orElse(hotelEntity);
        hotelEntity = hotelRepository.save(hotelEntity);

        RoomEntity roomEntity = roomMapper.toEntity(booking.getRoom());
        roomEntity = roomRepository.findById(booking.getRoom().getId()).orElse(roomEntity);
        roomEntity.setHotel(hotelEntity);
        roomEntity = roomRepository.save(roomEntity);

        GuestEntity guestEntity = guestMapper.toEntity(booking.getGuest());
        guestEntity = guestRepository.findById(booking.getGuest().getId()).orElse(guestEntity);
        guestEntity = guestRepository.save(guestEntity);

        BookingEntity bookingEntity = bookingMapper.toEntity(booking);
        bookingEntity.setRoom(roomEntity);
        bookingEntity.setGuest(guestEntity);
        BookingEntity savedEntity = bookingRepository.save(bookingEntity);

        return bookingMapper.toDomain(savedEntity);
    }

    @Override
    public boolean deleteById(String bookingId) {
        if (bookingId != null && !bookingId.trim().isEmpty()) {
            bookingRepository.deleteById(bookingId);
            return true;
        }
        return false;
    }
}