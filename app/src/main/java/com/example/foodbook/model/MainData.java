package com.example.foodbook.model;


import com.google.gson.annotations.SerializedName;

public class MainData {

    @SerializedName("userId")
    public String userId;
    @SerializedName("role")
    public UserRoleEntityEnum role;
    @SerializedName("username")
    public String username;
    @SerializedName("avatar")
    public String avatar;

    public MainData() {
    }

    public MainData(String userId, UserRoleEntityEnum role, String username, String avatar) {
        userId = this.userId;
        role = this.role;
        username = this.username;
        avatar = this.avatar;
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
