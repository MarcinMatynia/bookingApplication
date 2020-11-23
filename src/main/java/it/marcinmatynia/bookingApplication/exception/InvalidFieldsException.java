package it.marcinmatynia.bookingApplication.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.FieldError;

import java.util.List;

@RequiredArgsConstructor
@Getter
public class InvalidFieldsException extends RuntimeException {
    private final List<FieldError> errors;
}
