package it.marcinmatynia.bookingApplication.experts;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "experts")
class Expert {
    @Setter(AccessLevel.PACKAGE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "First name must be given")
    private String name;
    @NotBlank(message = "Surname must be given")
    private String surname;
}
