package org.docencia.hotel.web.rest;

import java.util.*;

import org.docencia.hotel.domain.api.HotelDomain;
import org.docencia.hotel.domain.model.Hotel;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Hotels", description = "Operaciones REST de hoteles")
@RestController
@RequestMapping("/api/hotels")
public class HotelController {

    private final HotelDomain hotelDomain;

    public HotelController(HotelDomain hotelDomain) {
        this.hotelDomain = hotelDomain;
    }

    @Operation(summary = "Obtener todos los hoteles")
    @GetMapping("/")
    public List<Hotel> getAllHotels() {
        return hotelDomain.findAll();
    }

    @Operation(summary = "Obtener hotel")
    @GetMapping("/{id}")
    public ResponseEntity<Hotel> findById(@PathVariable String id) {
        Hotel hotel = hotelDomain.findById(id).orElse(null);
        if (hotel == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(hotel);
    }

    @Operation(summary = "Guardar hotel")
    @PostMapping
    public ResponseEntity<Hotel> save(@Valid @RequestBody Hotel hotel) {
        return ResponseEntity.ok().body(hotelDomain.save(hotel));
    }

    @Operation(summary = "Eliminar hotel")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Hotel deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Hotel not found")
    })
    @DeleteMapping("/delete/hotel/{id}")
    public Map<String, Boolean> deleteHotel(@PathVariable(value = "id") String hotelId) {
        hotelDomain.deleteById(hotelId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
