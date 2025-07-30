package com.skillstorm.music.services;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.skillstorm.music.dtos.ArtistDTO;
import com.skillstorm.music.models.Artist;
import com.skillstorm.music.repositories.ArtistRepository;

@Service
public class ArtistService {
	
	private final ArtistRepository repo;
	
	public ArtistService(ArtistRepository repo) {
		this.repo = repo;
	}
	
	// find all
	public ResponseEntity<Iterable<Artist>> findAll() {
		Iterable<Artist> artists = this.repo.findAll();
		
		if (!artists.iterator().hasNext())
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
								 .build();
		
		return ResponseEntity.ok(artists);
	}
	
	// find by id
	public ResponseEntity<Artist> findById(int id) {
		Optional<Artist> artist = this.repo.findById(id);
		
		if (artist.isPresent())
			return ResponseEntity.ok(artist.get());
		
		return ResponseEntity.notFound().build();
	}
	
	// create one
	public ResponseEntity<Artist> createOne(ArtistDTO dto) {
		
		return ResponseEntity.status(HttpStatus.CREATED)
							 .body(this.repo.save(new Artist(0, dto.artistName(), dto.label(), dto.albums())));
	}
	
	// update one
	public ResponseEntity<Artist> updateOne(int id, ArtistDTO dto) {
		if (this.repo.existsById(id))
			return ResponseEntity.ok(this.repo.save(new Artist(id, dto.artistName(), dto.label(), dto.albums())));
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
							 .build();
	}
	
	// delete by id
	public ResponseEntity<Void> deleteById(int id) {
		this.repo.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}

}
