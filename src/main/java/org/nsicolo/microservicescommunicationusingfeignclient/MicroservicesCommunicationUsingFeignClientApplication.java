package org.nsicolo.microservicescommunicationusingfeignclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MicroservicesCommunicationUsingFeignClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroservicesCommunicationUsingFeignClientApplication.class, args);
    }

}
