package org.docencia.hotel.mapper.jpa;

import javax.annotation.processing.Generated;
import org.docencia.hotel.domain.model.Room;
import org.docencia.hotel.persistence.jpa.entity.RoomEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-09T19:38:58+0000",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 25 (Eclipse Adoptium)"
)
@Component
public class RoomMapperImpl implements RoomMapper {

    @Autowired
    private HotelMapper hotelMapper;

    @Override
    public RoomEntity toEntity(Room domain) {
        if ( domain == null ) {
            return null;
        }

        RoomEntity roomEntity = new RoomEntity();

        roomEntity.id( domain.getId() );
        roomEntity.setNumber( domain.getNumber() );
        roomEntity.setType( domain.getType() );
        roomEntity.setPrice_per_night( domain.getPrice_per_night() );
        roomEntity.setHotel( hotelMapper.toEntity( domain.getHotel() ) );

        return roomEntity;
    }

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
        room.setHotel( hotelMapper.toDomain( entity.getHotel() ) );

        return room;
    }
}
