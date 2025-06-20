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
		 * To hide data from other parts of the program, we use access modifiers
		 * public -- ANY part of the program can access it
		 * protected -- ONLY the class AND any class in the SAME PACKAGE...PLUS child classes in OTHER PACKAGES
		 * default (no modifier) -- ONLY the class itself AND any class in the SAME PACKAGE can access it
		 * private -- ONLY the class itself (or any methods within it) can access it
		 * 
		 * FULL ENCAPSULATION
		 * Issues to address:
		 * - exposure of private/internally-relevant-only data
		 * - invalid data entry for our properties
		 * 	-- negative numbers, invalid years, too-short Strings, etc.
		 *  -- internally inconsistent data, like changing height without changing area, etc.
		 *  
		 *  we address this with getters and setters (see other class for examples!)
		 *  -- getters and setters are METHODS to access or change property values
		 *  
		 *  Full Encapsulation = ALL private properties with getters and setters where desired
		 * 
		 */
		
		// instantiating a new Animal using Java's default constructor
		// the default constructor is a "no-args" constructor, meaning it doesn't take in anything
		// *** after we created our 4-args constructor, we needed to create a new no-args constructor to replace the no-longer-there default one
		Animal animal1 = new Animal();
		
		System.out.println(animal1.heightInInches);
		
		Animal animal2 = new Animal("Woofie", "Sheep Dog", 28.5, "Leftover Steak");
		
		System.out.println(animal2.name);
		System.out.println(animal2.type);
		System.out.println(animal2.heightInInches);
		System.out.println(animal2.diet);
		
		animal2.name = "Woofy";
		
		System.out.println(animal2.name);
		
		Animal animal3 = new Animal("Lord Tubbington", 14.0);
		
		System.out.println(animal3.name);
		System.out.println(animal3.type);
		System.out.println(animal3.heightInInches);
		System.out.println(animal3.diet);

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
	
	// when you create another constructor, like the one above
	// Java removes access to the default constructor
	// if you still want that functionality, you need to create a no-args constructor like the one below
	// this does exactly the same thing as the default constructor
	// *** CERT TIP ALERT ***
	// on the cert, they consider the constructor Java provides the "default constructor"
	// then, they call a constructor like the one we've created below a "no-args constructor"
	public Animal() {
		super();
	}
	
	// constructor overloading works just like method overloading, since a constructor IS a method
	// you can run whatever logic you want in a constructor to assign values, etc.
	public Animal(String name, double heightInInches) {
		super();
		this.name = name;
		this.heightInInches = heightInInches;
		this.type = "Cat";
		this.diet = "Treats";
	}
	
}















