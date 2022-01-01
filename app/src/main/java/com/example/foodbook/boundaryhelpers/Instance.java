package com.example.foodbook.boundaryhelpers;

public class Instance {
	private InstanceId instanceId;

	public Instance() {
		this.instanceId = new InstanceId();
	}

	public Instance(InstanceId instanceId) {
		this.instanceId = instanceId;

	}

	public InstanceId getInstanceId() {
		return instanceId;
	}

	public void setInstanceId(InstanceId instanceId) {
		this.instanceId = instanceId;
	}
}
