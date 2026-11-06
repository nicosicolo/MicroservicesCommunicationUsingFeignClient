package org.nsicolo.addressservice.exceptions;


import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CityNotFoundException extends RuntimeException {
    private String message;

    public CityNotFoundException (String message) {
        super(message);
        this.message = message;
    }
}
