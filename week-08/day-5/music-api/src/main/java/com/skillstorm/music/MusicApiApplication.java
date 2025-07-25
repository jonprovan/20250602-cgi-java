package com.skillstorm.music;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

}
