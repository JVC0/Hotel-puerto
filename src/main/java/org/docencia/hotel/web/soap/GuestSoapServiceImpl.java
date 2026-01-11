package org.docencia.hotel.web.soap;

import java.util.List;

import org.docencia.hotel.domain.api.GuestDomain;
import org.docencia.hotel.domain.model.Guest;
import jakarta.jws.WebService;
import org.springframework.stereotype.Service;

@Service
@WebService(
        endpointInterface = "org.docencia.hotel.web.soap.GuestSoapService",
        targetNamespace = "http://hotel.docencia.org/ws",
        serviceName = "GuestSoapService",
        portName = "GuestSoapPort"
)
public class GuestSoapServiceImpl implements GuestSoapService {

    private final GuestDomain guestDomain;

    public GuestSoapServiceImpl(GuestDomain guestDomain) {
        this.guestDomain = guestDomain;
    }

    @Override
    public Guest getGuestById(String id) {
        return guestDomain.findById(id).orElse(null);
    }

    @Override
    public Guest saveGuest(Guest guest) {
        return guestDomain.save(guest);
    }

    @Override
    public Boolean deleteGuest(String guestId) {
        guestDomain.deleteById(guestId);
        return true;
    }

    @Override
    public List<Guest> getAllGuests() {
        return guestDomain.findAll();
    }



}
