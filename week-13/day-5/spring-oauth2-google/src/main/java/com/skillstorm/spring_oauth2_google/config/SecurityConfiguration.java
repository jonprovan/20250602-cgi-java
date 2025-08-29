package com.skillstorm.spring_oauth2_google.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class SecurityConfiguration {



    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {


        http    
            .authorizeHttpRequests(request -> {
                request.anyRequest().authenticated();   // every single request the user needs to be authenticated for
            })
            .csrf(csrf -> csrf.disable())
            .cors(cors ->
                cors.configurationSource(request -> {
                    CorsConfiguration corsConfiguration = new CorsConfiguration().applyPermitDefaultValues();
                    corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:5173"));
                    corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
                    corsConfiguration.setAllowedHeaders(Arrays.asList("Authorization", "X-XSRF-TOKEN", "Content-Type", "Access-Control-Allow-Origin"));
                    corsConfiguration.setAllowCredentials(true);    // this allows your app to accept CORS pre-flight request (OPTIONS)
                    corsConfiguration.setMaxAge(3600L);

                    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
                    source.registerCorsConfiguration("/**", corsConfiguration);     // sets the above cors config to work on every endpoint in our project
                    return corsConfiguration;
                })
            )

            .oauth2Login(oauth -> Customizer.withDefaults());

        return http.build();
    }
}
