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

import com.skillstorm.music.dtos.LabelHistoryDTO;
import com.skillstorm.music.models.LabelHistory;
import com.skillstorm.music.services.LabelHistoryService;

@RestController
@RequestMapping("/label-histories")
public class LabelHistoryController {
	
	private final LabelHistoryService service;
	
	public LabelHistoryController(LabelHistoryService service) {
		this.service = service;
	}
	
	// find all labels
	@GetMapping
	public ResponseEntity<Iterable<LabelHistory>> findAll() {
		return this.service.findAll();
	}
	
	// find by id
	@GetMapping("/{id}")
	public ResponseEntity<LabelHistory> findById(@PathVariable int id) {
		return this.service.findById(id); 
	}
	
	// create one
	@PostMapping
	public ResponseEntity<LabelHistory> createOne(@RequestBody LabelHistoryDTO dto) {
		return this.service.createOne(dto);
	}
	
	// update one
	@PutMapping("/{id}")
	public ResponseEntity<LabelHistory> updateOne(@PathVariable int id, @RequestBody LabelHistoryDTO dto) {
		return this.service.updateOne(id, dto);
	}
	
	// delete by id
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable int id) {
		return this.service.deleteById(id);
	}

}