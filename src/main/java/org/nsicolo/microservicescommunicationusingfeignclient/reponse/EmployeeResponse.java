package org.nsicolo.microservicescommunicationusingfeignclient.reponse;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmployeeResponse {
    private int id;
    private String name;
    private String email;
    private String age;
}
