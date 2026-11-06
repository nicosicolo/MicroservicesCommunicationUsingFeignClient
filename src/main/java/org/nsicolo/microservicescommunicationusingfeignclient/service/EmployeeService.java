package org.nsicolo.microservicescommunicationusingfeignclient.service;

import org.modelmapper.ModelMapper;
import org.nsicolo.microservicescommunicationusingfeignclient.exceptions.EmployeeNotFoundException;
import org.nsicolo.microservicescommunicationusingfeignclient.model.Employee;
import org.nsicolo.microservicescommunicationusingfeignclient.response.EmployeeResponse;
import org.nsicolo.microservicescommunicationusingfeignclient.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public EmployeeResponse getEmployeeById(Long id) {
        Optional<Employee> employee = repository.findById(id);
        if (employee.isPresent()) {
            return modelMapper.map(employee.get(), EmployeeResponse.class);
        } else {
            throw new EmployeeNotFoundException("Employee not found");
        }
    }




}
