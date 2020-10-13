package it.marcinmatynia.bookingApplication.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
class ErrorDTO {
    private HttpStatus status;
    private Map<String, String> invalidFields;
}
