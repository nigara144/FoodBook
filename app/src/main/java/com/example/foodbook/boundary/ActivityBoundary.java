package com.example.foodbook.boundary;

import com.example.foodbook.boundaryhelpers.ActivityId;
import com.example.foodbook.boundaryhelpers.Instance;
import com.example.foodbook.boundaryhelpers.InvokedBy;

import java.util.Date;
import java.util.HashMap;

public class ActivityBoundary {
	private ActivityId activityId;
	private String type;
	private Instance instance;
	private Date createdTimestamp;
	private InvokedBy invokedBy;
	private HashMap<String, Object> activityAttributes;

	public ActivityBoundary() {
		this.activityId = new ActivityId();
		this.instance = new Instance();
		this.invokedBy = new InvokedBy();
		this.activityAttributes = new HashMap<>();

	}

	public ActivityBoundary(ActivityId activityId, String type, Instance instance, Date createdTimestamp,
			InvokedBy invokedBy, HashMap<String, Object> activityAttributes) {
		this();
		this.activityId = activityId;
		this.type = type;
		this.instance = instance;
		this.createdTimestamp = createdTimestamp;
		this.invokedBy = invokedBy;
		this.activityAttributes = activityAttributes;
	}

	public ActivityId getActivityId() {
		return activityId;
	}

	public String getType() {
		return type;
	}

	public Instance getInstance() {
		return instance;
	}

	public Date getCreatedTimestamp() {
		return createdTimestamp;
	}

	public InvokedBy getInvokedBy() {
		return invokedBy;
	}

	public HashMap<String, Object> getActivityAttributes() {
		return activityAttributes;
	}

	public void setActivityId(ActivityId activityId) {
		this.activityId = activityId;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setInstance(Instance instance) {
		this.instance = instance;
	}

	public void setCreatedTimestamp(Date createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}

	public void setInvokedBy(InvokedBy invokedBy) {
		this.invokedBy = invokedBy;
	}

	public void setActivityAttributes(HashMap<String, Object> activityAttributes) {
		this.activityAttributes = activityAttributes;
	}

}
