package com.skillstorm;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TheHashMapProblem {

	public static void main(String[] args) {
		
		/*
		 * THE HASHMAP PROBLEM
		 * 
		 * Two different instances of an object will return DIFFERENT hashCodes, even if they're equal in terms of properties, etc.
		 * The basic hashCode() method returns a hash based on the memory address
		 * This creates a problem with HashMaps, because looking up an equivalent object
		 * that has a different hashCode will NOT return the proper value from the Map
		 * 
		 * TO FIX -- we must override the hashCode() and the equals() methods
		 * These are methods of the Object class that must be fixed
		 * 
		 * The hashCode/equals contract
		 * - two equal objects MUST return the same hashCode
		 * - objects can be equal however we want them to be, i.e., based on whichever set of properties matters to us
		 * - two non-equal objects MAY STILL return the same hashCode
		 * 
		 * This solution happens in the class itself (overriding these methods)
		 * 
		 * Another reason that overriding the equals method is critical
		 * Is handling collisions -- when two different keys end up with the same hashCode
		 * Java will place them in the same HashMap bucket but distinguish between them based on the equals method
		 * Once you override hashCode/equals properly, you DO NOT HAVE TO WORRY ABOUT THIS!
		 */
		
		Map<Car, Double> cars = new HashMap<>();
		
		cars.put(new Car("Ford", "Festiva", 1989), 7999.99);
		cars.put(new Car("Toyota", "Corolla", 2004), 15000.00);
		cars.put(new Car("Honda", "CR-V", 2004), 17999.01);
		
		System.out.println(cars.get(new Car("Toyota", "Corolla", 2004)));
		
		Car c1 = new Car("Toyota", "Corolla", 2004);
		Car c2 = c1;
		System.out.println(c1.hashCode());
		System.out.println(c2.hashCode());
		
		// two different objects ARE ALLOWED to return the same hashCode
		System.out.println("Aa".hashCode());
		System.out.println("BB".hashCode());
		
		// now that we've properly overridden hashCode/equals, everything works as intended!
		Car c3 = new Car("Bugatti", "Chiron", 2025);
		Car c4 = new Car("Bugatti", "Chiron", 2025);
		
		// these objects now return the same hashCode, meeting the contract, since they're equal
		System.out.println(c3.hashCode());
		System.out.println(c4.hashCode());
		
		// and they properly return true for being equal directly
		System.out.println(c3.equals(c4));
		
		// our HashMap now does what it's supposed to do
		cars.put(c3, 3500000.00);
		
		System.out.println(cars.get(c4));
		System.out.println(cars.get(new Car("Bugatti", "Chiron", 2025)));
		
	}

}

class Car {
	
	public String make;
	public String model;
	public int year;
	
	public Car(String make, String model, int year) {
		this.make = make;
		this.model = model;
		this.year = year;
	}

	// this override makes it so that objects of this class generate their hashCodes based on the properties that would make them equal
	@Override
	public int hashCode() {
		return Objects.hash(make, model, year);
	}

	@Override
	public boolean equals(Object obj) {
		// this checks if this object and the one being compared to have the same memory address
		// i.e., are they the exact same object in the heap?
		if (this == obj)
			return true;
		// this checks if the object being compared to is null, i.e., does it even exist?
		if (obj == null)
			return false;
		// this checks to see if both this and the other object are the same class
		// in this case, if they're not both Cars, it returns false
		// you may want to adjust this if you equality is based on properties from parent classes, etc. (can use instanceof for this)
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		return Objects.equals(make, other.make) && Objects.equals(model, other.model) && year == other.year;
	}
	
}
