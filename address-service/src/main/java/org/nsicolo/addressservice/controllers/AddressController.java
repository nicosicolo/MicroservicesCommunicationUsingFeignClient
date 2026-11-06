package org.nsicolo.addressservice.controllers;

import org.nsicolo.addressservice.exceptions.CityNotFoundException;
import org.nsicolo.addressservice.responses.AddressResponse;
import org.nsicolo.addressservice.responses.ErrorResponse;
import org.nsicolo.addressservice.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${addressApiPrefix}/address")
public class AddressController {
    @Autowired
    private AddressService service;

    @GetMapping("/{employeeId}")
    public ResponseEntity<AddressResponse> findEmployeeAddress (@PathVariable Long employeeId) {
        AddressResponse employeeAddress = service.findAddressByEmployeeId(employeeId);
        return ResponseEntity.status(HttpStatus.OK).body(employeeAddress);
    }

    @ExceptionHandler(value = CityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleCityNotFoundException(CityNotFoundException exception) {
        return new ErrorResponse(HttpStatus.NOT_FOUND.value(), exception.getMessage());
    }
}
