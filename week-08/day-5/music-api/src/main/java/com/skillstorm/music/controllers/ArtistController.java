package com.skillstorm.music.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.music.dtos.ArtistDTO;
import com.skillstorm.music.models.Artist;
import com.skillstorm.music.services.ArtistService;

@RestController
@RequestMapping("/artists")
public class ArtistController {
	
	private final ArtistService service;
	
	public ArtistController(ArtistService service) {
		this.service = service;
	}
	
	// find all labels
	@GetMapping
	public ResponseEntity<Iterable<Artist>> findAll() {
		return this.service.findAll();
	}
	
	// find by id
	@GetMapping("/{id}")
	public ResponseEntity<Artist> findById(@PathVariable int id) {
		return this.service.findById(id); 
	}
	
	// create one
	@PostMapping
	public ResponseEntity<Artist> createOne(@RequestBody ArtistDTO dto) {
		return this.service.createOne(dto);
	}
	
	// update one
	@PutMapping("/{id}")
	public ResponseEntity<Artist> updateOne(@PathVariable int id, @RequestBody ArtistDTO dto) {
		return this.service.updateOne(id, dto);
	}
	
	// delete by id
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable int id) {
		return this.service.deleteById(id);
	}

}