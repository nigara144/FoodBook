package com.example.foodbook.boundary;


import com.example.foodbook.boundaryhelpers.UserId;

public class UserBoundary {
	private UserId userId;
	private UserRole role;
	private String username;
	private String avatar;

	public UserBoundary() {
		this.userId = new UserId();
	}

	public UserBoundary(UserId userId, UserRole role, String username, String avatar) {
		this();
		this.userId = userId;
		this.role = role;
		this.username = username;
		this.avatar = avatar;
	}
//	public UserBoundary(NewUserBoundary details) {
//		this.userId = new UserId(details.getEmail());
//		this.role = details.getRole();
//		this.username = details.getUsername();
//		this.avatar = details.getAvatar();
//	}

	public UserId getUserId() {
		return userId;
	}

	public UserRole getRole() {
		return role;
	}

	public String getAvatar() {
		return avatar;
	}

	public String getUsername() {
		return username;
	}

	public void setUserId(UserId userId) {
		this.userId = userId;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
