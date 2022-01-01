package com.example.foodbook.boundaryhelpers;

//helper class for activity boundary

public class ActivityId {
	private String domain;
	private String id;

	public ActivityId() {

	}

	public ActivityId(String domain, String id) {
		this.domain = domain;
		this.id = id;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getFullQualifiedId() {
		return this.domain + ";" + this.id;
	}
}