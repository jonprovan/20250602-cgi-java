package com.skillstorm.music.idclasses;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

// this class will be embedded as part of the entity described in ExecutiveWithEmbeddedId
// so we use the @Embeddable annotation on the class itself (and implement Serializable)
@Embeddable
public class ExecutiveIdForEmbeddedId implements Serializable {
	
	private int experience;
	private String firstName;
	
	public ExecutiveIdForEmbeddedId() {
		super();
	}

	public ExecutiveIdForEmbeddedId(int experience, String firstName) {
		super();
		this.experience = experience;
		this.firstName = firstName;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
}
