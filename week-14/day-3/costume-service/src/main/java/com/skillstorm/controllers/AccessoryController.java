package com.skillstorm.controllers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.models.Accessory;
import com.skillstorm.models.Costume;

@RestController
@RequestMapping("/accessory")
public class AccessoryController {
	
	/*
	 * NOTE -- we're doing EVERYTHING in the Controller here ONLY for expediency!
	 * You should still use the standard entity/repo/service/controller structure for real projects!
	 */
	
	
	// a list of objects we'll use like a mock database to return things to our users
	public static List<Accessory> accessories = new LinkedList<>(Arrays.asList(
				new Accessory(100, "Top Hat", 6),
				new Accessory(101, "Crown", 11),
				new Accessory(102, "Sharpie", 95),
				new Accessory(103, "Leaf Hat", 154),
				new Accessory(104, "Ten-Gallon Hat", 210),
				new Accessory(105, "Cane", 6),
				new Accessory(106, "Cape", 11),
				new Accessory(107, "Rubber Band", 95),
				new Accessory(108, "Basket", 154),
				new Accessory(109, "Lasso", 210)
			));
	
	@GetMapping
	public ResponseEntity<List<Accessory>> findAll() {
		return ResponseEntity.ok(accessories);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Accessory> findById(@PathVariable int id) {
		for (Accessory accessory : accessories) {
			if (accessory.id == id)
				return ResponseEntity.ok(accessory);
		}
		
		return ResponseEntity.notFound().build();
	}

}
