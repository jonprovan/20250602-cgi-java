package com.skillstorm.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.skillstorm.models.Costume;

/*
 * this interface maps out all the methods that reach out to the costume service
 * any available endpoint in the costume service can be accessed
 * however, ONLY endpoints that are mapped here will be reachable from this service
 * the name indicated in the @FeignClient annotation MUST match the service name from its application.yml file EXACTLY!!
 * so, this client will ONLY be able to reach out to the costume service and ONLY to the endpoints noted here
 */

@FeignClient(name = "costume-service")
public interface CostumeServiceClient {
	
	/*
	 * mappings used on methods in a FeignClient are the type of request being MADE, not received
	 * so this method, when called, will MAKE a get request to the costume service with this suffix
	 * 
	 * think of this as being structured as a flip of a controller endpoint in terms of how the annotations function
	 * in a controller, they describe what's COMING IN
	 * here, they describe what's GOING OUT
	 * 
	 * so, the @PathVariable annotation indicates that the id provided by the user should be used in the OUTGOING request's path variable
	 */
	@GetMapping("/costume/trick-or-treater/{id}")
	ResponseEntity<Costume> findCostumeByTrickOrTreaterId(@PathVariable int id);
	
	@PostMapping("/costume")
	ResponseEntity<Costume> createCostume(@RequestBody Costume costume);

}
