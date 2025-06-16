package com.skillstorm;

import java.util.HashMap;
import java.util.Map;

public class OOPConcepts {

	public static void main(String[] args) {
		
		/*
		 * OBJECT-ORIENTED PROGRAMMING (OOP)
		 * 
		 * Java is an OOP language
		 * (JavaScript, which we'll get to later, is NOT)
		 * 
		 * OOP aims to represent real-world "things" as programming objects
		 * 
		 * A class is a template or blueprint that describes common state and behavior for any number of objects
		 * -- Player class -> Jimmy, age 14, number 12, on the Devils
		 * 				   -> Marie, age 13, number 6, on the Saints
		 * 
		 * -- Team class -> Devils, 18 members, Coach Joe, blue/gray
		 * 				 -> Saints, 16 members, Coach Sue, red/green
		 * 
		 * An object is an "instance" created from a class
		 * -- e.g. one actual Player object from our Player class, etc.
		 * -- objects, once instantiated, live on the heap
		 * 
		 * Classes include a few key things:
		 * - instance properties -- specific to an instance, like Jimmy's name in his Player object
		 * - static properties -- belong to the class itself; each instance DOES NOT own its own version
		 * - instance methods -- a method you can run on that specific instance
		 * - static methods -- belong to the class itself; each instance DOES NOT have its own version
		 * - constructor(s) -- a special method in a class that returns a new instance of that class
		 * 					-- you can (or not) take in values to initialize properties in the class
		 * 
		 * EVERYTHING in Java is in a class somewhere, including this!
		 * -- the main method requires a class to go in
		 * 
		 * ALMOST everything in Java is an instantiated object as well
		 * -- custom objects
		 * -- Java library objects
		 * -- Arrays
		 * -- Collections
		 * -- Exceptions and Errors
		 * 
		 * 
		 * THE FOUR PILLARS OF OOP
		 * 
		 * Encapsulation
		 * -- wrapping related state and behavior into classes
		 * 	-- state = properties/attributes
		 * 	-- behavior = methods
		 * -- hiding data/behavior from outside "users" (access modifiers)
		 * 
		 * Inheritance
		 * -- a class can inherit from another class
		 * -- the child class gets ALL the state and ALL the behavior from its parent class and the parent class's parent class, etc.
		 * -- code reusability
		 * 
		 * Polymorphism
		 * -- "many shapes/forms"
		 * -- having one class or method take on different forms depending on the use case
		 * -- method overloading
		 * -- method overriding
		 * -- Objects can be multiple things at once, using IS-A/IS-AN relationships
		 * 
		 * Abstraction
		 * -- hiding the details of implementation -- how a certain thing is done -- from the "user"
		 * -- a "user" can be a person or another part of the program
		 * -- the user doesn't need to know HOW something happens, just THAT it happens
		 * -- abstract classes and interfaces
		 * 
		 */
		
		// instantiating an Object from Java's Object class
		// we use the "new" keyword to use the constructor method "Object()" and return a new instance of the Object class
		// the variable o now contains a reference to this new Object on the heap
		Object o = new Object();
		
		// creating a Player without a class
		// could be a mostly untyped array
		Object[] player = { "Jimmy", 14, 12, "Devils" };
		
		// could be a Map of some sort, where at least we have access to named properties
		Map<String, Object> player2 = new HashMap<>();
		
		// but we still have to do all this to create a player
		player2.put("name", "Jimmy");
		player2.put("age", 14);
		player2.put("number", 12);
		player2.put("team", "Devils");
		
		System.out.println(player2.get("name"));
		
		player2.put("name", false);
		
		System.out.println(player2.get("name"));
		
		// as opposed to something like this, where we'd have a Player class and be able to instantiate a Player using the constructor
//		Player player3 = new Player("Jimmy", 14, 12, "Devils");
//		
//		System.out.println(player3.name);

	}

}
