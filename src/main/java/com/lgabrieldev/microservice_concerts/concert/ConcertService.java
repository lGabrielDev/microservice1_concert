package com.lgabrieldev.microservice_concerts.concert;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lgabrieldev.microservice_concerts.concert.DTOs.ConcertCreateDto;
import com.lgabrieldev.microservice_concerts.concert.DTOs.ConcertFullDto;
import com.lgabrieldev.microservice_concerts.concert.DTOs.conversions.Conversions;

@Service
public class ConcertService {
    
    //attributes
    private ConcertRepository concertRepository;

    //constructors
    public ConcertService(ConcertRepository concertRepository){
        this.concertRepository = concertRepository;
    }


    // ----------------------------- CREATE ----------------------------- 
    public ConcertFullDto createConcert(ConcertCreateDto concertCreateDto){
        //todas as validacoes...... Fazer depois.....

        Concert concert = new Concert(concertCreateDto);

        return new ConcertFullDto(this.concertRepository.save(concert));
    }
    
    // ----------------------------- READ ALL ----------------------------- 
    public List<ConcertFullDto> getAllConcerts(){
        return Conversions.convert(this.concertRepository.findAll());
    }


    // ----------------------------- READ concert by #ID ----------------------------- 

}
