package org.nsicolo.addressservice.responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressResponse {
    private String City;
    private String State;
    private Long employeeId;
}
