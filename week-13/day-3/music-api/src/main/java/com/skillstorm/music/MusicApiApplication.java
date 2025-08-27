package com.skillstorm.music;

import java.util.Arrays;
import java.util.LinkedList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;

/*
 * Spring uses a LOT of annotations to indicate what classes' and properties' roles/functions are
 * SpringBootApplication is actually a composite annotation comprised of three sub-annotations:
 * - SpringBootConfiguration -- this allows this class to create Beans that will be used in application configuration
 * - EnableAutoConfiguration -- this enables the program to auto-configure everything it needs that we don't override
 * - ComponentScan -- this makes the application scan ALL classes in this package and any child packages for components/beans, etc.
 * 		-- anything we want to be available in the ApplicationContext MUST be in one of those packages!!
 * 		-- so files in com.skillstorm.music work, but not com.skillstorm.models, for instance
 * 		-- but com.skillstorm.music.models would work!
 */

@SpringBootApplication
public class MusicApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MusicApiApplication.class, args);
	}
	
		// quick security customization via a configuration Bean
		// @Bean
		// SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
			
		// 	// starting off the process by disabling basic authentication
		// 	http.httpBasic().disable();
			
		// 	// disabling Cross-Site Resource Forgery protection for now
		// 	http.csrf().disable();
			
		// 	// bypassing Cross-Origin Resource Sharing protection for now
		// 	http.cors(httpSecurityCorsConfigurer -> httpSecurityCorsConfigurer.configurationSource(request -> {
		//            CorsConfiguration cc = new CorsConfiguration().applyPermitDefaultValues();
		//            cc.setAllowedMethods(new LinkedList<>(Arrays.asList("GET", "POST", "PUT", "DELETE")));
		//            return cc;
		// 		})
		//     );
			
		// 	http.authorizeHttpRequests(requests -> {
				
		// 		// saying whether or not requests of certain methods/endpoints are allowed or denied
		// 		// once a request matches one of these, top-down, the rest are ignored!
		// 		requests.requestMatchers(HttpMethod.GET, "/**").permitAll();
		// 		requests.anyRequest().permitAll();
				
		// 	});
			
		// 	return http.build();
			
		// }

}

/*
 * HOW DOES THE SPRING FRAMEWORK WORK?
 * 
 * Spring is largely centered around the idea of a Bean
 * A Bean is an encapsulated class or interface that can be "injected" into another class via the ApplicationContext
 * When we designate a class as a Bean, Component, Controller, Service, Repository, etc.,
 *   we're making it available in the ApplicationContext
 * Once something is in the ApplicationContext, we can supply it to another class via Autowired, a setter, or a constructor
 *   WITHOUT having to manually instantiate it
 *   
 * This is called "dependency injection"
 * - our application's dependency on other software via the pom.xml IS NOT dependency injection!
 * - our service requiring a repository of a certain type to function IS dependency injection!
 * 
 * YOU CANNOT INJECT a class that has not been annotated as a Bean or Component of some sort
 * If the application cannot find a Bean of the correct type in the ApplicationContext, it will throw an Exception and stop before it's all the way up
 * 
 * Why does it work this way?
 * - Reason 1 -- this takes the control away from the user -- you MUST use this Bean as-is rather than customizing your own
 * - Reason 2 -- you can swap out what Beans are available at runtime to create different "profiles" for your app, like dev/test/prod, etc.
 * --- you could have a different database connection, set of endpoints, etc. for your dev profile vs. your prod profile
 * 
 * Inversion-Of-Control, IoC, the IoC Container, etc.
 * - by default, each Bean is a Singleton!
 * - there will only ever be one LabelService object, for example
 * - also, you don't customize it in any way, you just take the one that's available
 * - this plays into best practices for how to inject dependencies
 * - the control over the construction of the Bean should lie entirely with the Bean creator, NOT the user injecting the Bean
 * 
 */


