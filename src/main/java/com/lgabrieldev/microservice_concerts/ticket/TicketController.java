package com.lgabrieldev.microservice_concerts.ticket;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lgabrieldev.microservice_concerts.ticket.DTOs.TicketCreateDto;
import com.lgabrieldev.microservice_concerts.ticket.DTOs.TicketFullDto;
import com.lgabrieldev.microservice_concerts.ticket.DTOs.TicketOnlyIdAndEmailDto;

@RestController
@RequestMapping("")
public class TicketController {
    
    
    //attributes
    private TicketService ticketService;

    //constructors
    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }


    // ----------------------------- POST ----------------------------- 
    @PostMapping("/ticket")
    public ResponseEntity<String> createConcert(@RequestBody TicketCreateDto ticketCreateDto){
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(this.ticketService.createTicket(ticketCreateDto));
    }
    
    // ----------------------------- GET ALL -----------------------------
    @GetMapping("/ticket")
    public ResponseEntity<List<TicketOnlyIdAndEmailDto>> getAllTickets(){
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(this.ticketService.getAllTickets());
    }
    

    // ----------------------------- GET ticket by #ID ----------------------------- 
    @GetMapping("/ticket/{id}")
    public ResponseEntity<TicketFullDto> getConcertById(@PathVariable(name = "id") Long id){
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(this.ticketService.getTicketById(id));
    }
    
}
