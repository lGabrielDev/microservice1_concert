package com.lgabrieldev.microservice_concerts.concert.DTOs.conversions;

import java.util.ArrayList;
import java.util.List;

import com.lgabrieldev.microservice_concerts.concert.Concert;
import com.lgabrieldev.microservice_concerts.concert.DTOs.ConcertFullDto;


public abstract class Conversions {
    

    public static List<ConcertFullDto> convert(List<Concert> concerts){
        List<ConcertFullDto> concertFullDtos = new ArrayList<>();
        concerts.stream().forEach((concert) -> concertFullDtos.add(new ConcertFullDto(concert)));
        return concertFullDtos;
    }
}
