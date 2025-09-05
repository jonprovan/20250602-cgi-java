package com.skillstorm.models;

public class Costume {
	
	public int id;
	public String name;
	public int trickOrTreaterId;
	
	public Costume(int id, String name, int trickOrTreaterId) {
		super();
		this.id = id;
		this.name = name;
		this.trickOrTreaterId = trickOrTreaterId;
	}

	@Override
	public String toString() {
		return "Costume [id=" + id + ", name=" + name + ", trickOrTreaterId=" + trickOrTreaterId + "]";
	}

}
