package it.marcinmatynia.bookingApplication.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "experts")
public class Expert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private int id;

    private String name;

    private String surname;

    public Expert(final String name, final String surname) {
        this.name = name;
        this.surname = surname;
    }
}
