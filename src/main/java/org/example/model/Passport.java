package org.example.model;

import jakarta.persistence.*;
import lombok.*;
import org.example.model.enums.Country;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "passports")
@NoArgsConstructor
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "personal_number")
    private int personalNumber;
    private String name;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "day_of_birth")
    private LocalDate dayOfBirth;

    @Enumerated(EnumType.STRING)
    private Country country;

    @OneToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.REFRESH,
            CascadeType.MERGE,
    }, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Passport(int personalNumber, String name, String lastName, LocalDate dayOfBirth, Country country) {
        this.personalNumber = personalNumber;
        this.name = name;
        this.lastName = lastName;
        this.dayOfBirth = dayOfBirth;
        this.country = country;
    }
}
