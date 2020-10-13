package it.marcinmatynia.bookingApplication.exception;

import it.marcinmatynia.bookingApplication.tools.HasLogger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class InvalidIdExceptionHandler extends ResponseEntityExceptionHandler implements HasLogger {
    @ExceptionHandler(value = InvalidIdException.class)
    ResponseEntity<ErrorDTO> handleInvalidIdException(InvalidIdException ex){
        getLogger().error("An error happened while calling {}, problem with id: " + ex.getId(), ex.getStackTrace());

        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setStatus(HttpStatus.NOT_FOUND);
        errorDTO.setMessage("Id: " + ex.getId() + " was not found");
        return new ResponseEntity<>(errorDTO, errorDTO.getStatus());
    }
}
