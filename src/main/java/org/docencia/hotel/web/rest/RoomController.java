package org.docencia.hotel.web.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.docencia.hotel.domain.api.RoomDomain;
import org.docencia.hotel.domain.model.Room;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name = "Rooms", description = "Operaciones REST de habitaciones")
@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    private final RoomDomain roomDomain;

    public RoomController(RoomDomain roomDomain) {
        this.roomDomain = roomDomain;
    }

    @Operation(summary = "Obtener todas las habitaciones")
    @GetMapping
    public ResponseEntity<List<Room>> findAll() {
        return ResponseEntity.ok(roomDomain.findAll());
    }

    @Operation(summary = "Obtener habitación por ID")
    @GetMapping("/{id}")
    public ResponseEntity<Room> findById(@PathVariable String id) {
        return roomDomain.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Guardar habitación")
    @PostMapping
    public ResponseEntity<Room> save(@RequestBody Room room) {
        return ResponseEntity.ok(roomDomain.save(room));
    }

    @Operation(summary = "Eliminar habitación por ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        roomDomain.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}