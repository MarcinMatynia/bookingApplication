package it.marcinmatynia.bookingApplication.dto;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.Map;

@Getter
@Builder
public class ErrorDTO {
    private final HttpStatus status;
    private final String message;
    private final Map<String, String> invalidFields;
}
