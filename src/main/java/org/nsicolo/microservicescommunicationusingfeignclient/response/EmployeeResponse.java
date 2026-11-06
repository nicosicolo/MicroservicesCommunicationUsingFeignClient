package org.nsicolo.microservicescommunicationusingfeignclient.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmployeeResponse {
    private String name;
    private String email;
    private String age;
}
