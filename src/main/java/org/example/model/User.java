package org.example.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "users")
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    @Column(name = "last_name")
    private String lastName;
    private String email;
    private int age;

    @OneToOne(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE,
                    CascadeType.REFRESH,
                    CascadeType.DETACH,
                    CascadeType.REMOVE
            },
            fetch = FetchType.LAZY,
            mappedBy = "user"
    )
    private Passport passport;
    @OneToMany(cascade = {
            CascadeType.ALL
    },
            fetch = FetchType.LAZY,
            mappedBy = "owner")
    private List<Pet> pets;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "users_and_social_medias",
            inverseJoinColumns = @JoinColumn(name = "social_media_id"),
            joinColumns = @JoinColumn(name = "user_id"))
    private List<SocialMedia> socialMedias;

    public void setSocialMedias(SocialMedia socialMedia){
        if (socialMedias == null){
            socialMedias = new ArrayList<>();
        }
        socialMedias.add(socialMedia);
    }

    public void setPet(Pet pet) {
        if (pets == null) {
            pets = new ArrayList<>();
        }
        pets.add(pet);
    }

    public User(String name, String lastName, String email, int age) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
    }
}
