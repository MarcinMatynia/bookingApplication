package it.marcinmatynia.bookingApplication.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@Builder
@NoArgsConstructor
public class ExpertDTO {
    @NotBlank(message = "First name must be given")
    private String name;

    @NotBlank(message = "Surname must be given")
    private String surname;
}
