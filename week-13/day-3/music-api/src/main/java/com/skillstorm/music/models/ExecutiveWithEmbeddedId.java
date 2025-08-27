package com.skillstorm.music.models;

import com.skillstorm.music.idclasses.ExecutiveIdForEmbeddedId;
import com.skillstorm.music.idclasses.ExecutiveIdForIdClass;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

/*
 * there are two ways to handle composite keys if you're creating entities for classes that use them
 * this method used EmbeddedId, which is also a separate class
 * we will NOT include the properties of the id here, ONLY in the separate class
 * the class does not get annotated with regards to the id
 * the object property representing the id gets annotated with @EmbeddedId
 */

@Entity
@Table(name = "executive")
public class ExecutiveWithEmbeddedId {
	
	@EmbeddedId
	private ExecutiveIdForEmbeddedId id;

	public ExecutiveWithEmbeddedId() {
		super();
	}

	public ExecutiveWithEmbeddedId(ExecutiveIdForEmbeddedId id) {
		super();
		this.id = id;
	}

	public ExecutiveIdForEmbeddedId getId() {
		return id;
	}

	public void setId(ExecutiveIdForEmbeddedId id) {
		this.id = id;
	}

}
