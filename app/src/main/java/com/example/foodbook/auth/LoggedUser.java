package com.example.foodbook.auth;

import com.example.foodbook.boundary.UserBoundary;

import java.util.concurrent.atomic.AtomicReference;

public class LoggedUser {

    private final AtomicReference<UserBoundary> loggedUser;

    public LoggedUser() {
        this.loggedUser = new AtomicReference<>(null);
    }

    public UserBoundary getLoggedUser() {
        return loggedUser.get();
    }

    public void setLoggedUser(UserBoundary data) {
        loggedUser.set(data);
    }
}
