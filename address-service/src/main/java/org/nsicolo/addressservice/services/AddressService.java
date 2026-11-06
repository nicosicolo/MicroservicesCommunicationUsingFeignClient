package org.nsicolo.addressservice.services;

import org.modelmapper.ModelMapper;
import org.nsicolo.addressservice.exceptions.CityNotFoundException;
import org.nsicolo.addressservice.model.Address;
import org.nsicolo.addressservice.repositories.AddressRepository;
import org.nsicolo.addressservice.responses.AddressResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    private AddressRepository repository;

    @Autowired
    private ModelMapper mapper;

    public AddressResponse findAddressByEmployeeId(Long employeeId) {
        Optional<Address> address = repository.findByEmployeeId(employeeId);
        if (address.isPresent()) {
            return mapper.map(address.get(), AddressResponse.class);
        } else {
            throw new CityNotFoundException("Address not found.");
        }
    }
}
