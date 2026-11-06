package org.nsicolo.microservicescommunicationusingfeignclient.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "address-service", url = "${addressServiceURL}", path = "/v1/address")
public interface AddressClient {
    @GetMapping("/{employeeId}")
    ResponseEntity<AddressResponse> getEmployeeAddress(@PathVariable Long employeeId);
}
