package com.example.foodbook.objects;

import java.util.ArrayList;

public class User {
    private String email, UserName;
    private ArrayList<Recipe> userRecipes = new ArrayList<>();
    private ArrayList<Recipe> wishList = new ArrayList<>();
    String userImage, domain;

    public User() {
    }

    public User(String domain, String email) {
        this.email = email;
        this.domain = domain;
    }

    public User(String email, String userName, ArrayList<Recipe> userRecipes, ArrayList<Recipe> wishList, String userImage) {
        this.email = email;
        this.UserName = userName;
        this.userRecipes = userRecipes;
        this.wishList = wishList;
        this.userImage = userImage;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public ArrayList<Recipe> getUserRecipes() {
        return userRecipes;
    }

    public void setUserRecipes(ArrayList<Recipe> userRecipes) {
        this.userRecipes = userRecipes;
    }

    public ArrayList<Recipe> getWishList() {
        return wishList;
    }

    public void setWishList(ArrayList<Recipe> wishList) {
        this.wishList = wishList;
    }

    public void addRecipe(ArrayList<Recipe> recipes) {
        userRecipes.addAll(recipes);
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

}
