package it.marcinmatynia.bookingApplication.experts;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
class Expert {
    @Setter(AccessLevel.PACKAGE)
    private int id;
    private String name;
    private String surname;
}
