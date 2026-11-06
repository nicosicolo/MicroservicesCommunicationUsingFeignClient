package org.nsicolo.addressservice.repositories;

import org.nsicolo.addressservice.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Long> {
    Optional<Address> findByEmployeeId(Long employeeId);
}
