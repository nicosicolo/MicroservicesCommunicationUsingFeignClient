package org.nsicolo.microservicescommunicationusingfeignclient.clients;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressResponse {
    private String city;
    private String state;
}
