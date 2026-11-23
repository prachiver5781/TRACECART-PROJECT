package com.tracecart.service;

import java.sql.SQLException;
import com.tracecart.dao.UserDao;
import com.tracecart.model.User;

/** Handles registration and login for TraceCart users. */
public class AuthService {
    private final UserDao dao = new UserDao();

    public User login(String email, String password) throws SQLException {
        requireText(email, "Email");
        requireText(password, "Password");
        return dao.login(email.trim(), password);
    }

    public void register(String name, String email, String password) throws SQLException {
        requireText(name, "Name");
        requireText(email, "Email");
        requireText(password, "Password");
        dao.register(name.trim(), email.trim(), password);
    }

    private void requireText(String value, String field) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(field + " cannot be empty.");
        }
    }
}
