package com.skillstorm.music.controllers;

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

import com.skillstorm.music.dtos.AlbumDTO;
import com.skillstorm.music.models.Album;
import com.skillstorm.music.services.AlbumService;

@RestController
@RequestMapping("/albums")
public class AlbumController {
	
	private final AlbumService service;
	
	public AlbumController(AlbumService service) {
		this.service = service;
	}
	
	// find all
	@GetMapping
	public ResponseEntity<Iterable<Album>> findAll(@RequestParam(required = false) String from, 
												   @RequestParam(required = false) String to) {
		return this.service.findAll(from, to);
	}
	
	// find by id
	@GetMapping("/{id}")
	public ResponseEntity<Album> findById(@PathVariable int id) {
		return this.service.findById(id); 
	}
	
	// create one
	@PostMapping
	public ResponseEntity<Album> createOne(@RequestBody AlbumDTO dto) {
		return this.service.createOne(dto);
	}
	
	// update one
	@PutMapping("/{id}")
	public ResponseEntity<Album> updateOne(@PathVariable int id, @RequestBody AlbumDTO dto) {
		return this.service.updateOne(id, dto);
	}
	
	// delete by id
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable int id) {
		return this.service.deleteById(id);
	}

}