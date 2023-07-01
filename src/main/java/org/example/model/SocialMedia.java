package org.example.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@Table(name = "social_medias")
@NoArgsConstructor
public class SocialMedia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int rating;

    @ManyToMany(cascade = {
            CascadeType.DETACH,
            CascadeType.REFRESH,
            CascadeType.MERGE,
            CascadeType.PERSIST
    }, fetch = FetchType.LAZY,
            mappedBy = "socialMedias")
    private List<User> users;

    public void setUsers(User user) {
        if (users == null) {
            users = new ArrayList<>();
        }
        users.add(user);
    }

    public SocialMedia(String name, int rating) {
        this.name = name;
        this.rating = rating;
    }
}
