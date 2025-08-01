package com.skillstorm.music.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.music.dtos.ExecutiveWithEmbeddedIdDTO;
import com.skillstorm.music.models.ExecutiveWithEmbeddedId;
import com.skillstorm.music.services.ExecutiveWithEmbeddedIdService;

@RestController
@RequestMapping("/executive-with-embedded-id")
public class ExecutiveWithEmbeddedIdController {
	
	private ExecutiveWithEmbeddedIdService service;
	
	public ExecutiveWithEmbeddedIdController(ExecutiveWithEmbeddedIdService service) {
		this.service = service;
	}
	
	@GetMapping
	public Iterable<ExecutiveWithEmbeddedId> findAll() {
		return this.service.findAll();
	}
	
	@PostMapping
	public ExecutiveWithEmbeddedId findById(@RequestBody ExecutiveWithEmbeddedIdDTO dto) {
		return this.service.findById(dto);
	}

}
