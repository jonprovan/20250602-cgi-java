package com.skillstorm.controllers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.clients.InternalServiceClient;
import com.skillstorm.models.Accessory;
import com.skillstorm.models.Costume;

@RestController
@RequestMapping("/costume")
public class CostumeController {
	
	private InternalServiceClient internalServiceClient;
	
	public CostumeController(InternalServiceClient internalServiceClient) {
		super();
		this.internalServiceClient = internalServiceClient;
	}

	/*
	 * NOTE -- we're doing EVERYTHING in the Controller here ONLY for expediency!
	 * You should still use the standard entity/repo/service/controller structure for real projects!
	 */
	
	
	// a list of objects we'll use like a mock database to return things to our users
	public static List<Costume> costumes = new LinkedList<>(Arrays.asList(
				new Costume(6, "Fancy Gentleman", 1),
				new Costume(11, "Evil Queen", 2),
				new Costume(95, "Balloon Animal", 3),
				new Costume(154, "Blueberry", 4),
				new Costume(210, "Cowboy", 5)
			));
	
	@GetMapping
	public ResponseEntity<List<Costume>> findAll() {
		return ResponseEntity.ok(costumes);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Costume> findById(@PathVariable int id) {
		for (Costume costume : costumes) {
			if (costume.id == id)
				return ResponseEntity.ok(costume);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/{id}/accessories")
	public ResponseEntity<List<Accessory>> findAccessoriesByCostumeId(@PathVariable int id) {
		List<Accessory> accessories = new LinkedList<>();
		
		for (Accessory a : AccessoryController.accessories)
			if (a.costumeId == id)
				accessories.add(a);
				
		if (accessories.isEmpty())
			return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok(accessories);
	}
	
	// this endpoint can be reached normally, but also it's one we're calling to from our other service
	@GetMapping("/trick-or-treater/{id}")
	public ResponseEntity<Costume> findCostumeByTrickOrTreaterId(@PathVariable int id) {
		for (Costume costume : costumes) {
			if (costume.trickOrTreaterId == id)
				return ResponseEntity.ok(costume);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	// an endpoint to create a new costume and add it to the list
	@PostMapping
	public ResponseEntity<Costume> createCostume(@RequestBody Costume costume) {
		costumes.add(costume);
		if (costumes.contains(costume))
			return ResponseEntity.status(201).body(costume);
		return ResponseEntity.badRequest().build();
	}
	
	// this method gets the hello message from the internal service
	@GetMapping("/internal")
	public ResponseEntity<String> getHello() {
		return this.internalServiceClient.getHello();
	}
	

}
