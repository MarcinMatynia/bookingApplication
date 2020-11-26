package it.marcinmatynia.bookingApplication.dto;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
@Builder
public class ExpertDTO {
    @NotBlank(message = "First name must be given")
    private final String name;

    @NotBlank(message = "Surname must be given")
    private final String surname;
}
