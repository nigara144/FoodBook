package com.example.foodbook.boundaryhelpers;

//helper class for instance boundary
public class CreatedBy {
	private UserId userId;

	public CreatedBy() {
		this.userId = new UserId();
	}

	public CreatedBy(UserId userId) {
		this.userId = userId;

	}

	public UserId getUserId() {
		return userId;
	}

	public void setUserId(UserId userId) {
		this.userId = userId;
	}
}
