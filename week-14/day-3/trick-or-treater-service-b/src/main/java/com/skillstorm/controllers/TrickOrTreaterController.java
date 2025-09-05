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

import com.skillstorm.clients.CostumeServiceClient;
import com.skillstorm.models.Costume;
import com.skillstorm.models.TrickOrTreater;

import feign.FeignException;

@RestController
@RequestMapping("/trick-or-treater")
public class TrickOrTreaterController {
	
	// we inject our client just like injecting a service or a repo
	// constructor injection is preferred over setter or field injection
	private CostumeServiceClient costumeServiceClient;
	
	public TrickOrTreaterController(CostumeServiceClient costumeServiceClient) {
		this.costumeServiceClient = costumeServiceClient;
	}
	
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
	
	/*  this endpoint should return the costume for a requested trick-or-treater
	 *  since the costume information is on the other service,
	 *  we need to reach out to that service to get information
	 *  this COULD be done via RestTemplate, since in our case, we actually DO know the address of the other service
	 *  but, since we WILL NOT know the address of the other service in the real world
	 *  we will use a FeignClient to call the service by name rather than address
	 */
	
	@GetMapping("/{id}/costume")
	public ResponseEntity<Costume> findCostumeByTrickOrTreaterId(@PathVariable int id) {
		
		// regardless of whether you properly handle endpoints on the other end
		// if the FeignClient receives an Exception, you have to handle it on the calling end
		try {
			return this.costumeServiceClient.findCostumeByTrickOrTreaterId(id);
		} catch (FeignException e) {
			e.printStackTrace();
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping("/costume/create")
	public ResponseEntity<Costume> createCostume(@RequestBody Costume costume) {
		
		try {
			return this.costumeServiceClient.createCostume(costume);
		} catch (FeignException e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().build();
		}
	}
	
	// an endpoint for distinguishing which instance is serving a particular request
	// YOU WOULD NOT DO THIS in the real world -- each instance should be the same
	// just doing it here for illustrative purposes
	@GetMapping("/load-balancer-test")
	public ResponseEntity<TrickOrTreater> loadBalancerTest() {
		return ResponseEntity.ok(new TrickOrTreater(2, "Instance B"));
	}
	
}
