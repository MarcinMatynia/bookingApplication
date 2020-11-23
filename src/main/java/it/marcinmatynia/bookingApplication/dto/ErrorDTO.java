package it.marcinmatynia.bookingApplication.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.Map;

@Getter
@Builder
@NoArgsConstructor
public class ErrorDTO {
    private HttpStatus status;
    private String message;
    private Map<String, String> invalidFields;
}
