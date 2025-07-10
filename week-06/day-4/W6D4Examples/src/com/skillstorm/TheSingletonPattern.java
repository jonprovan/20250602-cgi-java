package com.skillstorm;

public class TheSingletonPattern {

	public static void main(String[] args) {
		
		/*
		 * THE SINGLETON PATTERN IN JAVA
		 * 
		 * this states that we ONLY want to have one instance EVER of a certain object type
		 * useful in frameworks for single copies of important data, single sets of API functionality, etc.
		 * 
		 * we need to use a private constructor
		 * to store and access the Singleton instance, we need to use static elements
		 */
		
		// these won't work
//		Singleton s = new Singleton();
//		Singleton s = Singleton.s;
		
		Singleton one = Singleton.getSingleton();
		Singleton two = Singleton.getSingleton();
		Singleton three = Singleton.getSingleton();
		
		// note that all three of these are the EXACT SAME INSTANCE
		System.out.println(one);
		System.out.println(two);
		System.out.println(three);
		
	}

}

class Singleton {
	
	// this holds the one and only one Singleton
	private static Singleton s = null;
	
	// constructor is private so users can't make multiple instances
	private Singleton() {}
	
	// this method either gets the existing Singleton or creates one if it hasn't been instantiated yet
	public static Singleton getSingleton() {
		
		if (s == null)
			s = new Singleton();
		return s;
		
	}
	
}




