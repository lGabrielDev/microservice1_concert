package com.lgabrieldev.microservice_concerts.microserviceEmail;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.lgabrieldev.microservice_concerts.ticket.DTOs.TicketFullDto;

@FeignClient(name = "microservice2", url = "http://localhost:8081")
public interface EmailController {
    

    @PostMapping("/send-email")
    public String sendEmail(@RequestBody TicketFullDto ticketFullDto);
}
