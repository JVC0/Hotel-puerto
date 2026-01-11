package org.docencia.hotel.mapper.jpa;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.docencia.hotel.domain.model.Room;
import org.docencia.hotel.persistence.jpa.entity.RoomEntity;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-11T02:54:41+0000",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.45.0.v20260106-1640, environment: Java 21.0.9 (Eclipse Adoptium)"
)
@Component
public class RoomMapperImpl implements RoomMapper {

    @Override
    public Room toDomain(RoomEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Room room = new Room();

        room.setId( entity.getId() );
        room.setNumber( entity.getNumber() );
        room.setType( entity.getType() );
        room.setPrice_per_night( entity.getPrice_per_night() );

        return room;
    }

    @Override
    public RoomEntity toEntity(Room domain) {
        if ( domain == null ) {
            return null;
        }

        RoomEntity roomEntity = new RoomEntity();

        roomEntity.setId( domain.getId() );
        roomEntity.setNumber( domain.getNumber() );
        roomEntity.setType( domain.getType() );
        roomEntity.setPrice_per_night( domain.getPrice_per_night() );

        return roomEntity;
    }

    @Override
    public List<Room> toDomainList(List<RoomEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<Room> list = new ArrayList<Room>( entities.size() );
        for ( RoomEntity roomEntity : entities ) {
            list.add( toDomain( roomEntity ) );
        }

        return list;
    }
}
