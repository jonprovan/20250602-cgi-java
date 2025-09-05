package com.skillstorm.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// you have more flexibility with endpoint naming here, because it's only being called internally
// so, the FeignClients will just call the internal-service, and you can have duplicate suffixes with other controllers in other services
// for instance, you can have GET costume-service/costume and GET internal-service/costume
@RequestMapping("/internal")
public class InternalController {
	
	@GetMapping
	public ResponseEntity<String> getHello() {
		return ResponseEntity.ok("Hello!");
	}

}
