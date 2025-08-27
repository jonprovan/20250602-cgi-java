package com.skillstorm.music.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            // authorizeHttpRequests tells spring security how to handle incoming requests
            .authorizeHttpRequests((request) -> 
                request
                    .requestMatchers("/users/hello-world").permitAll()      // allow ALL requests to /users/hello-world, even without authentication
                    .requestMatchers("/users/private").authenticated()      // users MUST be authenticated to access this endpoint
                    .requestMatchers("/users/register").permitAll()         // any new user can register
                    
            )
            
            // tells Spring security to use Basic Authentication instead of formLogin
            .httpBasic(basic -> {})      // sets default configuration 

            /**
             * Cross Site Request Forgery (CSRF)
             *  when someone tries to get access to a server with your credentials when you ar already authenticated.
             *  Spring Security auto-blocks any modifying requests (POST, PUT, DELETE) until this is handled
             */
        
            .csrf().disable();


        return http.build();
    }

    /**
     * spring security expects you to use bCrypt so you'll get issues if you use something else
     * bCrypt hashes your text for the specified number of times (cost factor)
     */
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }
}
