package com.skillstorm.music.idclasses;

import java.io.Serializable;

// an object of this class will represent a composite primary key for the purposes of database interaction
// it is a POJO (Plain Old Java Object) and does not require any annotations
// but it DOES need to implement Serializable
public class ExecutiveIdForIdClass implements Serializable {
	
	private int experience;
	private String firstName;
	
	public ExecutiveIdForIdClass() {
		super();
	}

	public ExecutiveIdForIdClass(int experience, String firstName) {
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
