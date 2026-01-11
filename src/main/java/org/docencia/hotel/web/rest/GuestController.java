package org.docencia.hotel.web.rest;


import java.util.*;

import org.docencia.hotel.domain.api.GuestDomain;
import org.docencia.hotel.domain.model.Guest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Guests", description = "Operaciones REST de huéspedes")
@RestController
@RequestMapping("/api/guests")
public class GuestController {

    private final GuestDomain guestDomain;

    public GuestController(GuestDomain guestDomain) {
        this.guestDomain = guestDomain;
    }

    @Operation(summary = "Obtener todos los huéspedes")
    @GetMapping("/")
    public List<Guest> getAllGuests() {
        return guestDomain.findAll();
    }

    @Operation(summary = "Obtener huésped")
    @GetMapping("/{id}")
    public ResponseEntity<Guest> findById(@PathVariable String id) {
        Guest task = guestDomain.findById(id).orElse(null);
        if (task == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(task);
    }

    @Operation(summary = "Guardar huésped")
    @PostMapping
    public ResponseEntity<Guest> save(@Valid @RequestBody Guest guest) {
        return ResponseEntity.ok().body(guestDomain.save(guest));
    }
    @Operation(summary = "Eliminar huésped ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User deleted successfully"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    @DeleteMapping("/delete/user/{id}")
    public Map<String, Boolean> deleteguest(@PathVariable(value = "id") String guestId){
        guestDomain.deleteById(guestId); 
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
