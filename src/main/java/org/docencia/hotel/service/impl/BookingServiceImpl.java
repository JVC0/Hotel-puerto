package org.docencia.hotel.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.docencia.hotel.domain.model.Booking;
import org.docencia.hotel.mapper.jpa.BookingMapper;
import org.docencia.hotel.persistence.jpa.entity.BookingEntity;
import org.docencia.hotel.persistence.repository.jpa.BookingRepository;
import org.docencia.hotel.service.api.BookingService;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService {
    private BookingRepository bookingRepository;
    private BookingMapper bookingMapper;

    public BookingServiceImpl(BookingRepository bookingRepository, BookingMapper bookingMapper) {
        this.bookingRepository = bookingRepository;
        this.bookingMapper = bookingMapper;
    }

    @Override
    public Optional<Booking> findById(String id) {
        BookingEntity booking= bookingRepository.findById(id).get();
        return Optional.of(bookingMapper.toDomain(booking));
    }

    @Override
    public List<Booking> findAll() {
        List<BookingEntity> bookings= bookingRepository.findAll();
        List<Booking> result = new ArrayList<>();
        for(BookingEntity booking: bookings){
            result.add(bookingMapper.toDomain(booking));
        }
        return result;
    }

    @Override
    public Booking save(Booking booking) {
        BookingEntity bookingEntity = bookingMapper.toEntity(booking);
        BookingEntity savedEntity = bookingRepository.save(bookingEntity);
        return bookingMapper.toDomain(savedEntity);
    }

    @Override
    public boolean deleteById(String bookingId) {
        if(bookingId!= null){
            bookingRepository.deleteById(bookingId);
            return true;
        }
        return false    ;
    }


    // TODO: inyectar repositorios + mappers y aplicar lógica
}
