package com.spring.mvc.model;

import javax.persistence.Entity;

@Entity
public class TwoWheeler extends Vehicle{
	private String SteeringHandle;

	public String getSteeringHandle() {
		return SteeringHandle;
	}

	public void setSteeringHandle(String steeringHandle) {
		SteeringHandle = steeringHandle;
	}
}
