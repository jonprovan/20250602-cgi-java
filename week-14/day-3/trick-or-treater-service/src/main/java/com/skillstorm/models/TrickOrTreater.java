package com.skillstorm.models;

public class TrickOrTreater {
	
	public int id;
	public String name;
	
	public TrickOrTreater(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "TrickOrTreater [id=" + id + ", name=" + name + "]";
	}

}
