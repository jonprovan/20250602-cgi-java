package com.skillstorm.controllers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.models.TrickOrTreater;

@RestController
@RequestMapping("/trick-or-treater")
public class TrickOrTreaterController {
	
	/*
	 * NOTE -- we're doing EVERYTHING in the Controller here ONLY for expediency!
	 * You should still use the standard entity/repo/service/controller structure for real projects!
	 */
	
	
	// a list of objects we'll use like a mock database to return things to our users
	private List<TrickOrTreater> trickOrTreaters = new LinkedList<>(Arrays.asList(
				new TrickOrTreater(1, "Charlie Bucket"),
				new TrickOrTreater(2, "Veruca Salt"),
				new TrickOrTreater(3, "Augustus Gloop"),
				new TrickOrTreater(4, "Violet Beauregard"),
				new TrickOrTreater(5, "Mike Teevee")
			));
	
	@GetMapping
	public ResponseEntity<List<TrickOrTreater>> findAll() {
		return ResponseEntity.ok(this.trickOrTreaters);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TrickOrTreater> findById(@PathVariable int id) {
		for (TrickOrTreater tot : trickOrTreaters) {
			if (tot.id == id)
				return ResponseEntity.ok(tot);
		}
		
		return ResponseEntity.notFound().build();
	}

}
