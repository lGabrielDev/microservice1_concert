package com.lgabrieldev.microservice_concerts.concert;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lgabrieldev.microservice_concerts.concert.DTOs.ConcertCreateDto;
import com.lgabrieldev.microservice_concerts.concert.DTOs.ConcertFullDto;

@RestController
@RequestMapping("")
public class ConcertController {
    
    
    //attributes
    private ConcertService concertService;

    //constructors
    public ConcertController(ConcertService concertService){
        this.concertService = concertService;
    }



    // ----------------------------- POST ----------------------------- 
    @PostMapping("/concert")
    public ResponseEntity<ConcertFullDto> createConcert(@RequestBody ConcertCreateDto concertCreateDto){
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(this.concertService.createConcert(concertCreateDto));
    }
    
    // ----------------------------- GET ALL ----------------------------- 
    @GetMapping("/concert")
    public ResponseEntity<List<ConcertFullDto>> getAllConcerts(){
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(this.concertService.getAllConcerts());
    }

    // ----------------------------- GET concert by #ID ----------------------------- 
}
