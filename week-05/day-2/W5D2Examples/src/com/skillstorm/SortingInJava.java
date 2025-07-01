package com.skillstorm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SortingInJava {

	public static void main(String[] args) {
		
		/*
		 * SORTING IN JAVA
		 * 
		 * We've used some sorting functionality before
		 * int[] nums = ...
		 * String[] words = ...
		 * 
		 * Arrays.sort() works on these arrays
		 * 
		 * LinkedList<Double> doubles = ...
		 * ArrayList<Character> characters = ...
		 * 
		 * Collections.sort() words on these collections
		 * 
		 * The reason this words for numbers and letters is that there's a NATURAL SORT ORDER
		 */
		
		Integer[] nums = { 6, 1, 100, -200, 0 };
		Arrays.sort(nums);
		
		System.out.println(Arrays.toString(nums));

		String[] letters = { "A", "a", "B", "b" };
		Arrays.sort(letters);
		
		System.out.println(Arrays.toString(letters));
		
		List<Double> doubles = new LinkedList<>(Arrays.asList(45.67, -9.11, 867.5309, 0.0, 10000.8888));
		Collections.sort(doubles);
		System.out.println(doubles);
		
		List<Character> characters = new ArrayList<>(Arrays.asList('d', 'u', 'a', 'z', 'c'));
		Collections.sort(characters);
		System.out.println(characters);
		
		// sorting with custom objects doesn't work at first...
		Car[] cars = { new Car("Ford", "Pinto"), new Car("Mercedes", "X300"), new Car("Acura", "Integra") };
		
		// this throws a ClassCastException
		// in order to use this method, the array we're sorting MUST be an array of something that can be cast as a Comparable
		// in other words, the things in the array must have an IS-A relationship with Comparable
		// the class MUST implement the Comparable interface
//		Arrays.sort(cars);
		
		// this method MUST take in something of a type that IS-A Comparable as well
		// it doesn't throw an Exception of the same type, but it won't run, either
//		Collections.sort(cars);
		
	}

}

class Car {
	
	public String make;
	public String model;
	
	public Car(String make, String model) {
		this.make = make;
		this.model = model;
	}
	
}
