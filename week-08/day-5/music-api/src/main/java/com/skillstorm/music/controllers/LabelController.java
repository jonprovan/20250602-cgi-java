package com.skillstorm.music.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	@Autowired
	private LabelService service;
	
	// find all labels
	// this annotation specifies that this method will handle GET requests to /labels with no additional suffix
	@GetMapping
	public Iterable<Label> findAll() {
		return this.service.findAll();
	}

}








