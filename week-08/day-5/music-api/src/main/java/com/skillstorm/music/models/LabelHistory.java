package com.skillstorm.music.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class LabelHistory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	
	@Column()
	private String history;
	
//	@Column
//	private int labelId;
	
	// to relate the tables in Spring and return records with nested related records, we do a few things:
	// we replace the foreign key property with an object of the type being referred to
	// the object type, since it is an entity itself, indicates what table we're referring to
	// we use @OneToOne to indicate the type of relationship and whether cascades will be occurring
	// we use JoinColumn to specify the column in this table with the foreign key (name) 
	// and the column in the other table to which the foreign key refers (referencedColumnName)
	// this is the controlling side (the table with the foreign key in it)
	// this looks a little different on the non-controlling side
	@OneToOne
	@JoinColumn(name = "label_id", referencedColumnName = "id")
	// this ignores the entirety of the Label JSON response and doesn't include ANY of it
//	@JsonIgnore
	// this ignores the specific properties of the linked object, rather than the entire thing
	// here, we're ignoring the property that refers back to this class
	// you can add multiple properties in the curly braces, separated by commas
	@JsonIgnoreProperties({"labelHistory"})
	private Label label;

	public LabelHistory() {
		super();
	}

	public LabelHistory(int id, String history, Label label) {
		super();
		this.id = id;
		this.history = history;
		this.label = label;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	public Label getLabel() {
		return label;
	}

	public void setLabel(Label label) {
		this.label = label;
	}
	
}
