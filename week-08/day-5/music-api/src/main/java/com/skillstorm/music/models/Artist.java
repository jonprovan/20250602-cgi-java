package com.skillstorm.music.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Artist {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	
	@Column
	private String artistName;
	
	// for many-to-one/one-to-many relationships, make sure you use the annotation that matches which side you're coming from
	// here, many Artists go with one Label, so we use ManyToOne
	// on the other side, we'll use OneToMany
	@ManyToOne
	@JoinColumn(name = "label_id", referencedColumnName = "id")
	@JsonIgnoreProperties({"artists", "labelHistory"})
	private Label label;

	public Artist() {
		super();
	}

	public Artist(int id, String artist_name, Label label) {
		super();
		this.id = id;
		this.artistName = artist_name;
		this.label = label;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public Label getLabel() {
		return label;
	}

	public void setLabel(Label label) {
		this.label = label;
	}
	
}
