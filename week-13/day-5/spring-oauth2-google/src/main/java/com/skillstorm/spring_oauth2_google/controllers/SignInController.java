package com.skillstorm.spring_oauth2_google.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller // RestController will try to return JSON by default, and our signin endpoint, CANNOT return JSON.
public class SignInController {

    @GetMapping("/signin")
    public RedirectView signin() {
        // set the access token in the cookie when the user signs in if you wanted

        /**
         * frontend will redirect to this endpoint
         * then spring security intercepts it and sends it to the auth server 
         * the user signs in to auth server (google)
         * oauth2 allows the request tocontinue to where it was going (this endpoint)
         * this endpoint is ONLY reached, if the user was able to sign in successfully in the auth server
         * so we just want to send them right back to the frontend
         */


        // send the user back to some page after they login
        return new RedirectView("http://localhost:5173");   
    }
}
