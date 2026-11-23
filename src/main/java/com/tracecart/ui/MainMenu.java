package com.tracecart.ui;

import com.tracecart.model.User;
import com.tracecart.service.AuthService;
import com.tracecart.util.Input;
import com.tracecart.util.TablePrinter;

/** Authentication-only menu owned by Prachi's module. */
public class MainMenu {
    private final Input in = new Input();
    private final AuthService auth = new AuthService();

    public void start() {
        while (true) {
            try {
                TablePrinter.heading("TRACECART - AUTHENTICATION");
                System.out.println("1. Register customer\n2. Login\n0. Exit");
                switch (in.number("Choose: ")) {
                    case 1 -> {
                        auth.register(in.text("Name: "), in.text("Email: "), in.text("Password: "));
                        System.out.println("Registration successful.");
                    }
                    case 2 -> {
                        User user = auth.login(in.text("Email: "), in.text("Password: "));
                        if (user == null) {
                            System.out.println("Incorrect credentials.");
                        } else {
                            System.out.println("Login successful. Welcome, " + user.getName() + "!");
                            System.out.println("Authenticated role: " + user.getRole());
                            System.out.println("Other role-specific menus will be connected during team integration.");
                        }
                    }
                    case 0 -> { return; }
                    default -> System.out.println("Invalid option.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
