package com.skillstorm.music.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	// using a logger to get better information printed out when we need messages
	// using the slf4j one here
	// we tie it to this class with getClass() so the messages show up marked as coming from this class
	Logger logger = LoggerFactory.getLogger(getClass());
	
	// find all
	// this method uses an optional Request Parameter
	// the syntax of a URL using the parameter would be localhost:8080/artists?startsWith=A
	@GetMapping
	public ResponseEntity<Iterable<Artist>> findAll(@RequestParam(required = false) String startsWith) {
		this.logger.trace("GET All Artists; startsWith = " + startsWith);
		this.logger.debug("GET All Artists; startsWith = " + startsWith);
		this.logger.info("GET All Artists; startsWith = " + startsWith);
		this.logger.warn("GET All Artists; startsWith = " + startsWith);
		this.logger.error("GET All Artists; startsWith = " + startsWith);
		
		return this.service.findAll(startsWith);
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
	
	@PostMapping("/{id}/albums")
	public ResponseEntity<Void> connectArtistToAlbum(@PathVariable("id") int artistId, @RequestParam(required = true) String[] albumIds) {
		return this.service.connectArtistToAlbum(artistId, albumIds);
	}
	
	@DeleteMapping("/{id}/albums")
	public ResponseEntity<Void> disconnectArtistFromAlbum(@PathVariable("id") int artistId, @RequestParam(required = true) String[] albumIds) {
		return this.service.disconnectArtistFromAlbum(artistId, albumIds);
	}
	
	// delete by id
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable int id) {
		return this.service.deleteById(id);
	}

}