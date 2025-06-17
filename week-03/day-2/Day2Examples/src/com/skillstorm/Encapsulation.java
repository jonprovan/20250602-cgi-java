package com.skillstorm;

public class Encapsulation {

	public static void main(String[] args) {
		
		/*
		 * ENCAPSULATION IN JAVA
		 * 
		 * - wrapping related state and behavior (properties and methods) into a class
		 * - hiding data/functionality from other parts of the program (access control)
		 * 
		 * - properties and methods in a class should be related to the class and what it does
		 * - there is no practical min/max for properties and methods -- just create what you need
		 * 
		 * 
		 */
		
		// instantiating a new Animal using Java's default constructor
		// the default constructor is a "no-args" constructor, meaning it doesn't take in anything
		Animal animal1 = new Animal();
		
		System.out.println(animal1.heightInInches);

	}

}

// a file, like this Encapsulation.java file may ONLY have ONE public class
// you CAN have NO public classes, but if you have one, it MUST be the one whose name matches the file name
// the class with the main method MUST be public

// this is a class declaration -- use the "class" keyword, then the name of the class in PascalCase
// all custom class inherit from Java's Object class, whether we say so or not
class Animal {
	
	// this is an instance property declaration
	// now that we're in a class and not a method, we can (and have to) give it an access modifier
	// we CAN initialize it here
	// if we DON'T, it gets the default value (0 or 0.0 for numbers, null for Objects, etc.)
	public String name;
	public String type;
	public double heightInInches;
	public String diet;
	
	// Java provides a default constructor, if you don't make one
	
	// a custom constructor
	// constructors are methods, so they have access modifiers, too
	// they return a new instance of the class
	// they MUST be called the name of the class with a capital letter
	// they DO NOT have a return type, because they ALWAYS return an instance of the class
	public Animal(String name, String type, double heightInInches, String diet) {
//		super();			// this calls the superclass's constructor (Object, in this case); it's implied but useful later on (must come first)
		this.name = name;
		this.type = type;
		this.heightInInches = heightInInches;
		this.diet = diet;
	}
	
	public Animal() {}
	
}















