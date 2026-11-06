package org.nsicolo.microservicescommunicationusingfeignclient.controller;

import org.nsicolo.microservicescommunicationusingfeignclient.exceptions.EmployeeNotFoundException;
import org.nsicolo.microservicescommunicationusingfeignclient.response.EmployeeResponse;
import org.nsicolo.microservicescommunicationusingfeignclient.response.ErrorResponse;
import org.nsicolo.microservicescommunicationusingfeignclient.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "${employeeApiPrefix}/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/{id}")
    private ResponseEntity<EmployeeResponse> getEmployee(@PathVariable Long id) {
        EmployeeResponse employee = employeeService.getEmployeeById(id);
        return ResponseEntity.status(HttpStatus.OK).body(employee);
    }

    @ExceptionHandler(value = EmployeeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleEmployeeNotFoundException(EmployeeNotFoundException exception) {
        return new ErrorResponse(HttpStatus.NOT_FOUND.value(), exception.getMessage());
    }
}
