package com.example.foodbook.boundaryhelpers;

import java.util.Objects;

public class UserId {
	private String domain;
	private String email;

	public UserId() {

	}

	public UserId(String domain, String email) {
		this();
		this.email = email;
		this.domain = domain;
	}

	public String getDomain() {
		return domain;
	}

	public String getEmail() {
		return email;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public void setEmail(String email) {
		this.email = email;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserId userId = (UserId) o;
        return Objects.equals(domain, userId.domain) && Objects.equals(email, userId.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(domain, email);
    }
}
