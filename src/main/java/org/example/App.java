package org.example;

import org.example.model.Passport;
import org.example.model.Pet;
import org.example.model.SocialMedia;
import org.example.model.User;
import org.example.model.enums.Country;
import org.example.service.UserService;

import java.time.LocalDate;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        UserService userService = new UserService();

        Passport passport = new Passport(
                111,
                "MEDER",
                "TYNYCHPEKOV",
                LocalDate.of(2000, 11, 8),
                Country.KG);

        User meder = new User("Meder", "Tynychbekov", "meder@gmail.com", 22);

        passport.setUser(meder);
        meder.setPassport(passport);

        Pet dog = new Pet("Daisy", 2, "Husky", "dark_grey");
        Pet cat = new Pet("Garfeild", 3, "AA", "tiger-yellow");

        meder.setPet(dog);
        dog.setOwner(meder);

        meder.setPet(cat);
        cat.setOwner(meder);

        SocialMedia instagram = new SocialMedia("instagram", 5);

        SocialMedia facebook = new SocialMedia("Facebook", 5);

        meder.setSocialMedias(instagram);
        meder.setSocialMedias(facebook);

        instagram.setUsers(meder);
        facebook.setUsers(meder);

        User user = new User("MEDER", "TYNYCHBEKOV", "meder@gmail.com", 44);

        user.setSocialMedias(instagram);
        user.setSocialMedias(facebook);

        userService.save(user);

        userService.save(meder);

    }
}
