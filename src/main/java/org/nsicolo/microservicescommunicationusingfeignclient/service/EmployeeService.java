package org.nsicolo.microservicescommunicationusingfeignclient.service;

import org.modelmapper.ModelMapper;
import org.nsicolo.microservicescommunicationusingfeignclient.clients.AddressClient;
import org.nsicolo.microservicescommunicationusingfeignclient.clients.AddressResponse;
import org.nsicolo.microservicescommunicationusingfeignclient.exceptions.EmployeeNotFoundException;
import org.nsicolo.microservicescommunicationusingfeignclient.model.Employee;
import org.nsicolo.microservicescommunicationusingfeignclient.response.EmployeeResponse;
import org.nsicolo.microservicescommunicationusingfeignclient.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AddressClient addressClient;

    public EmployeeResponse getEmployeeById(Long employeeId) {
        Optional<Employee> employee = repository.findById(employeeId);
        if (employee.isPresent()) {
            EmployeeResponse employeeResponse = modelMapper.map(employee.get(), EmployeeResponse.class);
            ResponseEntity<AddressResponse> employeeAddress = addressClient.getEmployeeAddress(employeeId);
            if (employeeAddress.getStatusCode().is2xxSuccessful()) {
                employeeResponse.setAddress(employeeAddress.getBody());
            }
            return employeeResponse;
        } else {
            throw new EmployeeNotFoundException("Employee not found");
        }
    }




}
