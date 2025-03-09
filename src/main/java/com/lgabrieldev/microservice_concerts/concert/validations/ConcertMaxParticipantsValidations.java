package com.lgabrieldev.microservice_concerts.concert.validations;

import com.lgabrieldev.microservice_concerts.validations.GenericValidations;

public class ConcertMaxParticipantsValidations {

    //cannot be null
    public static Boolean maxParticipantsIsNotNull(Integer maxParticipants){

        if(GenericValidations.fieldIsNotNull(maxParticipants) == false){
            throw new RuntimeException(String.format("maxParticipants cannot be NULL!"));
        }
        return true;
    }

    //participant limit is 10.0000
    public static Boolean maxParticipantesIsUnder10Thousand(Integer maxParticipants){

        if(maxParticipants >= 10000 ){
            throw new RuntimeException(String.format("Too much participants. Max --> 10.000"));
        }
        return true;
    }

    //all validations are good 
    public static Boolean allValidationsAreGood(Integer maxParticipants){
        ConcertMaxParticipantsValidations.maxParticipantsIsNotNull(maxParticipants);
        ConcertMaxParticipantsValidations.maxParticipantesIsUnder10Thousand(maxParticipants);
        return true;
    }}
