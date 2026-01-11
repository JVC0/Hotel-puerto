package org.docencia.hotel.web.soap;

import java.util.List;

import org.docencia.hotel.domain.model.Guest;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;

@WebService(
        name = "GuestSoapService",
        targetNamespace = "http://hotel.docencia.org/ws"
)
public interface GuestSoapService {

    @WebMethod(operationName = "GetGuestById")
    @WebResult(name = "guest")
    Guest getGuestById(@WebParam(name = "id") String id);

    @WebMethod(operationName = "SaveGuest")
    @WebResult(name = "guest")
    Guest saveGuest(@WebParam(name = "guest") Guest guest);

    @WebMethod(operationName = "DeleteGuest")
    @WebResult(name = "success")
    Boolean deleteGuest(@WebParam(name = "guestId") String guestId);

    @WebMethod(operationName = "GetallGuests")
    @WebResult(name = "guest")
    List<Guest> getAllGuests();
}
