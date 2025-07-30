package com.skillstorm.music.services;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.skillstorm.music.dtos.AlbumDTO;
import com.skillstorm.music.models.Album;
import com.skillstorm.music.repositories.AlbumRepository;

@Service
public class AlbumService {
	
	private final AlbumRepository repo;
	
	public AlbumService(AlbumRepository repo) {
		this.repo = repo;
	}
	
	// find all
	public ResponseEntity<Iterable<Album>> findAll() {
		Iterable<Album> albums = this.repo.findAll();
		
		if (!albums.iterator().hasNext())
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
								 .build();
		
		return ResponseEntity.ok(albums);
	}
	
	// find by id
	public ResponseEntity<Album> findById(int id) {
		Optional<Album> album = this.repo.findById(id);
		
		if (album.isPresent())
			return ResponseEntity.ok(album.get());
		
		return ResponseEntity.notFound().build();
	}
	
	// create one
	public ResponseEntity<Album> createOne(AlbumDTO dto) {
		
		return ResponseEntity.status(HttpStatus.CREATED)
							 .body(this.repo.save(new Album(0, dto.albumName(), dto.releaseYear(), dto.artists())));
	}
	
	// update one
	public ResponseEntity<Album> updateOne(int id, AlbumDTO dto) {
		if (this.repo.existsById(id))
			return ResponseEntity.ok(this.repo.save(new Album(id, dto.albumName(), dto.releaseYear(), dto.artists())));
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
							 .build();
	}
	
	// delete by id
	public ResponseEntity<Void> deleteById(int id) {
		this.repo.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}

}