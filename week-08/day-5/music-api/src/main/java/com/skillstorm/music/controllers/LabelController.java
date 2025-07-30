package com.skillstorm.music.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.music.dtos.LabelDTO;
import com.skillstorm.music.models.Label;
import com.skillstorm.music.services.LabelService;

// this is a composite annotation of @Controller and @ResponseBody
// @Controller designates this class as a place for parsing endpoints
// any endpoints listed properly here will be available for users to interact with
// @ResponseBody says that this class DOES NOT return HTML views, rather HttpResponses with information in the body
// they won't get a webpage, just a JSON/XML response
@RestController
// this says that all requests formatted like "localhost:8080/labels" followed by whatever will route to this controller
@RequestMapping("/labels")
public class LabelController {
	
	// injecting our service here like we did with our repo in our service class
//	@Autowired
	private final LabelService service;
	
	public LabelController(LabelService service) {
		this.service = service;
	}
	
	// find all
	// this annotation specifies that this method will handle GET requests to /labels with no additional suffix
	@GetMapping
	public ResponseEntity<Iterable<Label>> findAll() {
		return this.service.findAll();
	}
	
	// find by id
	// this endpoint requires a path variable -- the user might request something like localhost:8080/labels/5
	// whatever you add in the mapping parentheses gets tacked on to whatever the RequestMapping annotation says at the top of the class
	// the name you refer to the variable as in the annotation is important
	// if the name of the variable in the annotation is different from the one in the method parameters
	// you MUST use the parentheses after the PathVariable annotation to indicate which one goes with the method parameter, like below
	// if the names match, you DO NOT need the PathVariable parentheses AT ALL!
	@GetMapping("/{labelId}")
	public ResponseEntity<Label> findById(@PathVariable("labelId") int id) {
		return this.service.findById(id); 
	}
	
	// create one
	// the @RequestBody annotation states that the JSON in the request body should be mapped to this type of object, called this variable name
	// if the user submits a malformed request body, they'll get an error message back
	@PostMapping
	public ResponseEntity<Label> createOne(@RequestBody LabelDTO dto) {
		return this.service.createOne(dto);
	}
	
	// update one
	@PutMapping("/{id}")
	public ResponseEntity<Label> updateOne(@PathVariable int id, @RequestBody LabelDTO dto) {
		return this.service.updateOne(id, dto);
	}
	
	// delete by id
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable int id) {
		return this.service.deleteById(id);
	}

}








