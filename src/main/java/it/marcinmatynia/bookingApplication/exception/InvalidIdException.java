package it.marcinmatynia.bookingApplication.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class InvalidIdException extends RuntimeException{
    private final Integer id;
}
