package com.skillstorm;

public class JavaBasics {
	
	// this is a Java comment
	// this text will not execute
	// we can use it for notes, explanations, to-dos, etc.
	// you can Ctrl-/ to comment one or more lines
	
	/*
	 * this is a multi-line comment
	 * as you press enter, it continues the comment
	 * just type slash-star, then press enter to begin
	 */
	
	/*
	 * WHAT IS JAVA?
	 * 
	 * backend programming language in OUR full-stack environment
	 * Object-Oriented Programming language -- we'll use classes/objects to represent entities in our program
	 * can run on ANY system that has the JVM (Java Virtual Machine)
	 * JVM -- can be installed/used without any programming knowledge, it virtualizes Java and runs Java programs on ANY OS
	 * JRE -- Java Runtime Environment, dictates what version of Java can be run in this instance
	 * JDK -- Java Developer Kit, provides libraries (packages, methods, static helper classes, etc.) to develop programs in Java
	 * 
	 * Everything in Java is a class -- a blueprint for an object/instance
	 * Classes are organized in packages -- mainly for organization/encapsulation
	 * 
	 * Programs begin at the main method
	 * - the class can be called whatever we want, but the method has a specific signature
	 * - the main method then runs top-to-bottom
	 * - when the main method is complete, the program ends
	 * 
	 * Class names are Pascal Case -- MyClass, LinkedList, HashMap, etc. (no spaces, dashes, etc.)
	 * Method names are camel Case -- myMethod, offerFirst, getAll, etc. (also no spaces, dashes, etc.)
	 * Property names == same as methods (numberOfLegs, interiorColor, etc.)
	 */

	// a main method
	
	/*
	 * public -- access modifier, means this method can be called from ANYWHERE in our program
	 * static -- can be accessed BEFORE an instance of this class is created
	 * void -- return type, what the method returns to whatever called it, void == nothing
	 * main -- the name of the method, must be called "main" for the main method
	 * () -- contains any parameters our method takes in
	 * String[] args -- this describes an array of Strings that we're calling args
	 */
	
	public static void main(String[] args) {
		// println prints to console, then line breaks
		System.out.println("Hello World!");
		
		// print prints to console WITHOUT line breaking
		System.out.print("This is me printing a line.");
		System.out.print("And it keeps going...");
		
		// System.out.println(args[2]);
	}
	
	


}
