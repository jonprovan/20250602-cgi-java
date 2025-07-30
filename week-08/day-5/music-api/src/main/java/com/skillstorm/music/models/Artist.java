package com.skillstorm.music.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
	
	// for many-to-many, use the @ManyToMany annotation
	// the JoinTable annotation maps out the relationships from the separate join table
	// name = the name of the join table
	// joinColumns = the name of the column(s) in the join table that point back to this class (the controlling side)
	// inverseJoinColumns = the name of the column(s) in the join table that point to the class on the other side
	@ManyToMany
	@JoinTable(name = "artist_albums_album",
			   joinColumns = @JoinColumn(name = "artist_id"),
			   inverseJoinColumns = @JoinColumn(name = "album_id"))
	@JsonIgnoreProperties({"artists"})
	private List<Album> albums;

	public Artist() {
		super();
	}

	public Artist(int id, String artistName, Label label, List<Album> albums) {
		super();
		this.id = id;
		this.artistName = artistName;
		this.label = label;
		this.albums = albums;
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

	public List<Album> getAlbums() {
		return albums;
	}

	public void setAlbums(List<Album> albums) {
		this.albums = albums;
	}
	
}
