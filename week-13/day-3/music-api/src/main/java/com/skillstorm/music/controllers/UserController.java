package com.skillstorm.music.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.music.models.AppUser;
import com.skillstorm.music.services.UserService;

import java.security.Principal;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/hello-world")
    public String hello() {
        return "Hello World!";
    }
    
    @GetMapping("/private")
    public String privateData(Principal principal, Authentication auth) {

        /**
         * created and populated by SecurityContext
         *  - Principal - the user. info on the user. 
         *  - Authentication - info about auth 
         */

        return "some private data: " + principal.getName();
    }


    @GetMapping("/login")
    public ResponseEntity<String> login(Principal principal, CsrfToken token) {
        if(token.getToken() != null){
            return ResponseEntity.ok("User: [" + principal.getName() + "] is signed in.");
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).header("message", "User: is not signed in.").build();
    }


    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody AppUser user) {
        try {
            userService.register(user);
            return new ResponseEntity<>(HttpStatus.CREATED);        // 201
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().header("message", e.getMessage()).build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().header("message", e.getMessage()).build();
        }
    }

    @PostMapping("/register/admin")
    public ResponseEntity<Void> registerAdmin(@RequestBody AppUser user) {
        try {
            userService.registerAdmin(user);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);     // 204
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().header("message", e.getMessage()).build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().header("message", e.getMessage()).build();
        }
    }
    
    


}
