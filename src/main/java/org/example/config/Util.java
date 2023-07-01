package org.example.config;

import org.example.model.Passport;
import org.example.model.Pet;
import org.example.model.SocialMedia;
import org.example.model.User;
import org.hibernate.SessionException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Util {

    public static SessionFactory getSession() {
        SessionFactory sessionFactory = null;
        try {
            Configuration configuration = new Configuration()
                    .addAnnotatedClass(User.class)
                    .addAnnotatedClass(Passport.class)
                    .addAnnotatedClass(Pet.class)
                    .addAnnotatedClass(SocialMedia.class)
                    .configure("hibernate.cfg.xml");
            sessionFactory = configuration.buildSessionFactory();
        } catch (SessionException e) {
            System.out.println(e.getMessage());
        }
        return sessionFactory;
    }
}
