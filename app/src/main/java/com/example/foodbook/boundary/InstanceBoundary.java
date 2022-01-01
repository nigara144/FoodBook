package com.example.foodbook.boundary;


import com.example.foodbook.boundaryhelpers.CreatedBy;
import com.example.foodbook.boundaryhelpers.InstanceId;
import com.example.foodbook.boundaryhelpers.Location;

import java.util.Date;
import java.util.HashMap;

public class InstanceBoundary {
	private InstanceId instanceId;
	private String type;
	private String name;
	private Boolean active;
	private Date createdTimestamp;
	private CreatedBy createdBy;
	private Location location;
	private HashMap<String, Object> instanceAttributes;

	public InstanceBoundary() {
		this.instanceId = new InstanceId();
		this.createdBy = new CreatedBy();
		this.location = new Location();
		this.instanceAttributes = new HashMap<>();
	}

	public InstanceBoundary(InstanceId instanceId, String type, String name, Boolean active, Date createdTimestamp,
			CreatedBy createdBy, Location location, HashMap<String, Object> instanceAttributes) {
		this();
		this.instanceId = instanceId;
		this.type = type;
		this.name = name;
		this.active = active;
		this.createdTimestamp = createdTimestamp;
		this.createdBy = createdBy;
		this.location = location;
		this.instanceAttributes = instanceAttributes;

	}

	public InstanceId getInstanceId() {
		return instanceId;
	}

	public String getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	public Boolean getActive() {
		return active;
	}

	public Date getCreatedTimestamp() {
		return createdTimestamp;
	}

	public CreatedBy getCreatedBy() {
		return createdBy;
	}

	public Location getLocation() {
		return location;
	}

	public HashMap<String, Object> getInstanceAttributes() {
		return instanceAttributes;
	}

	public void setInstanceId(InstanceId instanceId) {
		this.instanceId = instanceId;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public void setCreatedTimestamp(Date createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}

	public void setCreatedBy(CreatedBy createdBy) {
		this.createdBy = createdBy;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public void setInstanceAttributes(HashMap<String, Object> instanceAttributes) {
		this.instanceAttributes = instanceAttributes;
	}
	
	@Override
	public String toString() {
		return "InstanceEntity [id=" + instanceId + ", type=" + type + ", name=" + name + ", active=" + active 
				+ ", createdTimestamp=" + createdTimestamp + ", createdBy=" + createdBy	+ ", lat=" + location.getLat()
				+ ", lng=" + location.getLng() + ", instanceAttributes=" + instanceAttributes;
	}
}
