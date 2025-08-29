package com.skillstorm.spring_oauth2_google.controllers;

import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;


import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class UserController {


    private final OAuth2AuthorizedClientService clientService;

    public UserController(OAuth2AuthorizedClientService clientService) {
        this.clientService = clientService;
    }


    @GetMapping("/hello-world")
    public String helloWorld() {
        return "Hello World!";
    }

    // shows how to get the access token for the user
    @GetMapping("/access-token")
    public void accessToken(Authentication auth, HttpServletResponse response) {
        
        // auth is the correct type of auth
        if(auth instanceof OAuth2AuthenticationToken) {

            // go ahead and cast it to the correct type
            OAuth2AuthenticationToken oAuth2 = (OAuth2AuthenticationToken) auth;

            // get the token with those authentication values
            OAuth2AuthorizedClient client = clientService.loadAuthorizedClient(oAuth2.getAuthorizedClientRegistrationId(), oAuth2.getName());

            // adding the access token to an HTTP only cookie
            Cookie cookie = new Cookie("Access Token", client.getAccessToken().getTokenValue());
            cookie.isHttpOnly();
            response.addCookie(cookie);     // response is automatically returned with the method

            //return client.getAccessToken().getTokenValue(); // return the access token as a String
        }
    }

    // gets the user's info from the OAuth2 scope
    @GetMapping("/user-info")
    public Map<String, Object> getMethodName(@AuthenticationPrincipal OAuth2User user) {
        return user.getAttributes();
    }
    
    
    
}
