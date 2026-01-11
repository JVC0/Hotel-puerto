package org.docencia.hotel.web.rest;

import java.util.*;

import org.docencia.hotel.domain.api.BookingDomain;
import org.docencia.hotel.domain.model.Booking;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Bookings", description = "Operaciones REST de reservas")
@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingDomain bookingDomain;

    public BookingController(BookingDomain bookingDomain) {
        this.bookingDomain = bookingDomain;
    }

    @Operation(summary = "Obtener todas las reservas")
    @GetMapping("/")
    public List<Booking> getAllBookings() {
        return bookingDomain.findAll();
    }

    @Operation(summary = "Obtener reserva")
    @GetMapping("/{id}")
    public ResponseEntity<Booking> findById(@PathVariable String id) {
        Booking booking = bookingDomain.findById(id).orElse(null);
        if (booking == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(booking);
    }

    @Operation(summary = "Guardar reserva")
    @PostMapping
    public ResponseEntity<Booking> save(@Valid @RequestBody Booking booking) {
        return ResponseEntity.ok().body(bookingDomain.save(booking));
    }

    @Operation(summary = "Eliminar reserva")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Booking deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Booking not found")
    })
    @DeleteMapping("/delete/booking/{id}")
    public Map<String, Boolean> deleteBooking(@PathVariable(value = "id") String bookingId) {
        bookingDomain.deleteById(bookingId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}