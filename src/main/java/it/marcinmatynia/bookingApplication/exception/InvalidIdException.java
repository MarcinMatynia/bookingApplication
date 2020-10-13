package it.marcinmatynia.bookingApplication.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class InvalidIdException extends RuntimeException{
    private final Integer id;
}
