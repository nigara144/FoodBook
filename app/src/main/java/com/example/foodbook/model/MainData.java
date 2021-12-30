package com.example.foodbook.model;


import com.example.foodbook.objects.User;
import com.google.gson.annotations.SerializedName;

public class MainData {

    @SerializedName("userId")
    public User user;
    @SerializedName("role")
    public UserRoleEntityEnum role;
    @SerializedName("username")
    public String username;
    @SerializedName("avatar")
    public String avatar;

    public MainData() {
    }

    public MainData(User user, UserRoleEntityEnum role, String username, String avatar) {

        this.user = user;
        this.role = role;
        this.username = username;
        this.avatar = avatar;
    }


    public UserRoleEntityEnum getRole() {
        return role;
    }

    public void setRole(UserRoleEntityEnum role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }


    public static enum UserRoleEntityEnum {
        PLAYER, MANAGER, ADMIN
    }
}
