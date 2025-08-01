package com.skillstorm.music.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.music.models.ExecutiveWithIdClass;
import com.skillstorm.music.services.ExecutiveWithIdClassService;

@RestController
@RequestMapping("/executive-with-id-class")
public class ExecutiveWithIdClassController {
	
	private ExecutiveWithIdClassService service;
	
	public ExecutiveWithIdClassController(ExecutiveWithIdClassService service) {
		this.service = service;
	}
	
	@GetMapping
	public Iterable<ExecutiveWithIdClass> findAll() {
		return this.service.findAll();
	}
	
	@GetMapping("/experience/{experience}/first-name/{firstName}")
	public ExecutiveWithIdClass findById(@PathVariable int experience, @PathVariable String firstName) {
		return this.service.findById(experience, firstName);
	}

}
