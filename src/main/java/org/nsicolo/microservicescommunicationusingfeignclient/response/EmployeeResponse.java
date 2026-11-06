package org.nsicolo.microservicescommunicationusingfeignclient.response;

import lombok.Getter;
import lombok.Setter;
import org.nsicolo.microservicescommunicationusingfeignclient.clients.AddressResponse;

@Setter
@Getter
public class EmployeeResponse {
    private String name;
    private String email;
    private String age;
    private AddressResponse address;
}
