package com.example.foodbook;

import com.example.foodbook.auth.LoggedUser;

public class GlobalState {

    private static final LoggedUser loggedUser = new LoggedUser();

    public static LoggedUser getLoggedUser() {
        return loggedUser;
    }
}
