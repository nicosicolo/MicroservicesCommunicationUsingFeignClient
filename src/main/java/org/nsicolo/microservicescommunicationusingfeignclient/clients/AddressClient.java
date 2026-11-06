package org.nsicolo.microservicescommunicationusingfeignclient.clients;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "AddressService", url = "${addressServiceURL}")
public interface AddressClient {
}
