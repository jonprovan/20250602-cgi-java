package com.skillstorm.models;

public class Accessory {
	
	public int id;
	public String name;
	public int costumeId;
	
	public Accessory(int id, String name, int costumeId) {
		super();
		this.id = id;
		this.name = name;
		this.costumeId = costumeId;
	}

	@Override
	public String toString() {
		return "Accessory [id=" + id + ", name=" + name + ", costumeId=" + costumeId + "]";
	}

}
