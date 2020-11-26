package it.marcinmatynia.bookingApplication.exception;

import it.marcinmatynia.bookingApplication.dto.ErrorDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@ControllerAdvice
public class ErrorsExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = InvalidFieldsException.class)
    ResponseEntity<ErrorDTO> handleInvalidFieldsException(InvalidFieldsException ex){
        log.error("An error happened while calling {}",ex.toString());

        Map<String,String> invalidFields = new HashMap<>();
        ex.getErrors()
                .forEach(e-> invalidFields.put(e.getField(), e.getDefaultMessage()));

        var errorDTO = ErrorDTO.builder()
                .invalidFields(invalidFields)
                .status(HttpStatus.BAD_REQUEST)
                .build();

        return new ResponseEntity<>(errorDTO, errorDTO.getStatus());

    }

    @ExceptionHandler(value = InvalidIdException.class)
    ResponseEntity<ErrorDTO> handleInvalidIdException(InvalidIdException ex){
        log.error("An error happened while calling {}, problem with id: " + ex.getId(), ex.getStackTrace());

        var errorDTO = ErrorDTO.builder()
                .status(HttpStatus.NOT_FOUND)
                .message("Id: " + ex.getId() + " was not found")
                .build();

        return new ResponseEntity<>(errorDTO, errorDTO.getStatus());
    }
}
