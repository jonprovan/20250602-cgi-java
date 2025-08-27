package com.skillstorm.music.models;

import com.skillstorm.music.idclasses.ExecutiveIdForIdClass;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

/*
 * there are two ways to handle composite keys if you're creating entities for classes that use them
 * this method uses IdClass, which requires a separate class for the Id
 * with this method, just mark ALL fields in the composite key with @Id
 * the class must be annotated with @IdClass(), with the name of the id class in the parentheses
 */

@Entity
@Table(name = "executive")
@IdClass(ExecutiveIdForIdClass.class)
public class ExecutiveWithIdClass {
	
	@Id
	@Column
	private int experience;
	
	@Id
	@Column
	private String firstName;

	public ExecutiveWithIdClass() {
		super();
	}

	public ExecutiveWithIdClass(int experience, String firstName) {
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
