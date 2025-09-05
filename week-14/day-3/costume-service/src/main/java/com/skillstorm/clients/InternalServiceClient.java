package com.skillstorm.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

// at the app level, we use @EnableFeignClients to search for FeignClient beans in the various packages
// here, we use FeignClient to create an injectable Bean we can use elsewhere
@FeignClient(name = "internal-service")
public interface InternalServiceClient {
	
	// make sure you match the full URL suffix for the endpoint, the return type, and the RequestParams/PathVariables/RequestBody
	@GetMapping("/internal")
	ResponseEntity<String> getHello();

}
