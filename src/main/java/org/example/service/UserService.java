package org.example.service;

import org.example.config.Util;
import org.example.model.User;
import org.hibernate.Session;
import org.hibernate.SessionException;

import java.util.List;

public class UserService implements Service<User> {

    @Override
    public void save(User user) {
        try (Session session = Util.getSession().openSession()) {

            session.beginTransaction();
            session.persist(user);
            session.getTransaction().commit();

            System.out.println("User successfully saved!!!");
        } catch (SessionException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public User update(int id, User user) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User findById(int id) {
        return null;
    }
}
