package com.lgabrieldev.microservice_concerts.errors;

import java.time.format.DateTimeParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.lgabrieldev.microservice_concerts.concert.errors.ConcertIsFullException;
import com.lgabrieldev.microservice_concerts.concert.errors.DateInThePastException;
import com.lgabrieldev.microservice_concerts.concert.errors.MaxParticipantsIsWrongException;
import com.lgabrieldev.microservice_concerts.concert.errors.TitleIsNotUniqueException;
import com.lgabrieldev.microservice_concerts.ticket.errors.ConcertIdIsWrongException;
import com.lgabrieldev.microservice_concerts.ticket.errors.EmailAlreadyRegisteredInConcertException;
import com.lgabrieldev.microservice_concerts.ticket.errors.EmailIsWrongException;
import com.lgabrieldev.microservice_concerts.ticket.validations.TicketIdIsWrongException;

@ControllerAdvice
public class GlobalExceptionHandler {

    // ============ general errors ============
    @ExceptionHandler(FieldCannotBeNullException.class)
    public ResponseEntity<DefaultErrorDto> fieldCannotBeNullExceptionHanlder(FieldCannotBeNullException e){
        DefaultErrorDto defaultErrorDto = new DefaultErrorDto();
        defaultErrorDto.setStatus(HttpStatus.BAD_REQUEST.value());
        defaultErrorDto.setErrorMessage(e.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(defaultErrorDto);
    }

    @ExceptionHandler(FieldLengthIsWrongException.class)
    public ResponseEntity<DefaultErrorDto> fieldLengthIsWrongExceptionHanlder(FieldLengthIsWrongException e){
        DefaultErrorDto defaultErrorDto = new DefaultErrorDto();
        defaultErrorDto.setStatus(HttpStatus.BAD_REQUEST.value());
        defaultErrorDto.setErrorMessage(e.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(defaultErrorDto);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<DefaultErrorDto> httpMessageNotReadableExceptionHanlder(HttpMessageNotReadableException e){
        DefaultErrorDto defaultErrorDto = new DefaultErrorDto();
        
        defaultErrorDto.setStatus(HttpStatus.CONFLICT.value());

        String errorMessage = e.getCause().getMessage(); 
        String fieldError = e.getCause().getMessage().substring(errorMessage.indexOf("[\"") + 2, errorMessage.indexOf("\"]"));
        defaultErrorDto.setErrorMessage(String.format(" '%s' cannot be a String!", fieldError));
        return ResponseEntity.status(HttpStatus.CONFLICT).body(defaultErrorDto);
    }

    // ============ concert errors ============
    @ExceptionHandler(ConcertIsFullException.class)
    public ResponseEntity<DefaultErrorDto> concertIsFullExceptionHandler(ConcertIsFullException e){
        DefaultErrorDto defaultErrorDto = new DefaultErrorDto();
        defaultErrorDto.setStatus(HttpStatus.BAD_REQUEST.value());
        defaultErrorDto.setErrorMessage(e.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(defaultErrorDto);
    }

    @ExceptionHandler(DateTimeParseException.class)
    public ResponseEntity<DefaultErrorDto> dateTimeParseExceptionHandler(DateTimeParseException e){
        DefaultErrorDto defaultErrorDto = new DefaultErrorDto();
        defaultErrorDto.setStatus(HttpStatus.BAD_REQUEST.value());
        defaultErrorDto.setErrorMessage(String.format("Date format '%s' is wrong. It should be like --> 'dd-MM-yyyy' ", e.getParsedString()));

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(defaultErrorDto);
    }

    @ExceptionHandler(DateInThePastException.class)
    public ResponseEntity<DefaultErrorDto> dateInThePastExceptionHandler(DateInThePastException e){
        DefaultErrorDto defaultErrorDto = new DefaultErrorDto();
        defaultErrorDto.setStatus(HttpStatus.BAD_REQUEST.value());
        defaultErrorDto.setErrorMessage(e.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(defaultErrorDto);
    }

    @ExceptionHandler(MaxParticipantsIsWrongException.class)
    public ResponseEntity<DefaultErrorDto> maxParticipantsIsWrongExceptionHandler(MaxParticipantsIsWrongException e){
        DefaultErrorDto defaultErrorDto = new DefaultErrorDto();
        defaultErrorDto.setStatus(HttpStatus.BAD_REQUEST.value());
        defaultErrorDto.setErrorMessage(e.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(defaultErrorDto);
    }

    @ExceptionHandler(TitleIsNotUniqueException.class)
    public ResponseEntity<DefaultErrorDto> titleIsNotUniqueExceptionHandler(TitleIsNotUniqueException e){
        DefaultErrorDto defaultErrorDto = new DefaultErrorDto();
        defaultErrorDto.setStatus(HttpStatus.CONFLICT.value());
        defaultErrorDto.setErrorMessage(e.getMessage());

        return ResponseEntity.status(HttpStatus.CONFLICT).body(defaultErrorDto);
    }

    // ============ ticket errors ============
    @ExceptionHandler(ConcertIdIsWrongException.class)
    public ResponseEntity<DefaultErrorDto> concertIdIsWrongExceptionHandler(ConcertIdIsWrongException e){
        DefaultErrorDto defaultErrorDto = new DefaultErrorDto();
        defaultErrorDto.setStatus(HttpStatus.BAD_REQUEST.value());
        defaultErrorDto.setErrorMessage(e.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(defaultErrorDto);
    }

    @ExceptionHandler(TicketIdIsWrongException.class)
    public ResponseEntity<DefaultErrorDto> ticketIdIsWrongExceptionHandler(TicketIdIsWrongException e){
        DefaultErrorDto defaultErrorDto = new DefaultErrorDto();
        defaultErrorDto.setStatus(HttpStatus.BAD_REQUEST.value());
        defaultErrorDto.setErrorMessage(e.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(defaultErrorDto);
    }

    @ExceptionHandler(EmailAlreadyRegisteredInConcertException.class)
    public ResponseEntity<DefaultErrorDto> emailAlreadyRegisteredInConcertExceptionHandler(EmailAlreadyRegisteredInConcertException e){
        DefaultErrorDto defaultErrorDto = new DefaultErrorDto();
        defaultErrorDto.setStatus(HttpStatus.BAD_REQUEST.value());
        defaultErrorDto.setErrorMessage(e.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(defaultErrorDto);
    }

    @ExceptionHandler(EmailIsWrongException.class)
    public ResponseEntity<DefaultErrorDto> emailIsWrongExceptionHandler(EmailIsWrongException e){
        DefaultErrorDto defaultErrorDto = new DefaultErrorDto();
        defaultErrorDto.setStatus(HttpStatus.BAD_REQUEST.value());
        defaultErrorDto.setErrorMessage(e.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(defaultErrorDto);
    }
}