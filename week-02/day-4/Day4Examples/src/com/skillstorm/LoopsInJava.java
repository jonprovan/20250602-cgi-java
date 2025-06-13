package com.skillstorm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LoopsInJava {

	public static void main(String[] args) {
		
		/*
		 * LOOPS IN JAVA
		 * 
		 * loops run code over and over in a circle until <something>
		 * we can run a loop until something is true (condition)
		 * we can also run a loop a fixed number of times
		 * - example -- do this once for each item in a collection/array
		 * we can do something at least once and then loop it if necessary
		 * OR, we can ONLY do it if a condition is true
		 * 
		 * while loops -- while and do-while
		 * for loops -- standard for and enhanced for (also foreach, but that's used elsewhere)
		 * 
		 */
		
		// the while loop
		// a while loop will execute as long as a condition is true
		// if the condition is NEVER true, it will NEVER execute
		
		int counter = 0;
		// if this line were uncommented, the loop would never execute
		// the condition is checked BEFORE each iteration of the loop
//		counter = 5;
		
		
		while (counter < 3) {
			System.out.println("While Loop Counter = " + counter);
			// if the increment were gone here, we'd be stuck in an infinite loop!
			// we'd never make it past the loop
			// so we need to be sure we have some way of altering the state of the condition
			counter++;
		}
		
		System.out.println("While Loop COMPLETE!\n");
		
		
		// the do-while loop
		// the do-while loop ALWAYS executes at least once
		// the condition is checked AFTER each iteration, BEFORE the next one
		
		// note that this value makes the condition NEVER true
		// but the loop still executes the first time
		counter = 3;
		
		do {
			System.out.println("Do-While Loop Counter = " + counter);
			counter++;
		} while (counter < 3);
		
		System.out.println("Do-While Loop COMPLETE!");
		
		// with user input
//		Scanner scan = new Scanner(System.in);
//		
//		System.out.println("\nPlease Enter Your Name:");
//		
//		String[] names = { "Elizabeth", "Jeff", "Jon", "Michael", "Tiffiny" };
//		
//		boolean redo = false;
//		String result = "";
//		
//		do {
//			String input = scan.nextLine().trim();
//			if (Arrays.binarySearch(names, input) < 0) {
//				redo = true;
//				System.out.println("Please try again:");
//			} else {
//				redo = false;
//				result = input;
//			}
//		} while (redo);
//		
//		System.out.println("Your name is: " + result);
//		
//		scan.close();
		
		
		// the standard for loop
		// usually, this loop will create an internal index, increment it until some value, then stop and remove the variable from memory
		// there are three things that go into the setup of a standard for loop
		// 1. something to do ONCE BEFORE the loop EVER starts (usually setting up the variable)
		// 2. a condition to check BEFORE EACH iteration of the loop
		// 3. something to do AFTER each iteration of the loop (usually incrementing the variable)
		
		/*
		 *  SYNTAX
		 *  
		 *  for (<something to do once before>; <condition>; <something to do after each>) {
		 *  ...some code
		 *  }
		 */
		
		System.out.println();

		for (int i = 0; i < 5; i++) {
			System.out.println("Standard For Loop Index Currently at: " + i);
		}
		
		System.out.println();
		
		// since the index starts at zero (usually) and increments, this structure is GREAT for array/collection access
		// the enhanced for DOES NOT have an index, so you have do some extra work if you want index access there
		// whether or not you do anything with each value in the array is up to you
		// you can use conditionals to choose whether or not to process each one, etc.
		
		String[] movies = { "The Boondock Saints", "The Hobbit Trilogy", "Dead Alive", "28 Years Later", "Fried Green Tomatoes" };
		
		for (int i = 0; i < movies.length; i++) {
			System.out.println(movies[i]);
		}
		
		System.out.println();

		
		// the enhanced for loop
		// for each item in an array or collection or anything iterable...
		// do something!
		// there's no index being incremented here, so one disadvantage is we don't have index-based access
		// HOWEVER, we define a variable on setup that automatically has the value of whichever item we're looking at
		
		for (String movie : movies) {
			System.out.println(movie);
		}
		
		System.out.println();
		
		int[][] nums = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		
		for (int[] line : nums) {
			System.out.println(Arrays.toString(line));
		}
		
		System.out.println();
		
		// with Objects...
		Film[] films = { new Film("Barry Lyndon"), new Film("The Joy Luck Club"), new Film("Do The Right Thing") };
		
		for (Film film : films) {
			System.out.println(film.title);
		}
		
		System.out.println();
		
		// some collections can't be iterated, so they don't work with enhanced for
		Map<Integer, String> students = new HashMap<>();
		
		students.put(6, "Tiffiny");
		students.put(2, "Jeff");
		students.put(3, "Elizabeth");
		students.put(5, "Michael");
		
		System.out.println(students.get(3));
		
		// can't do this, because Maps are not iterable!
//		for (Integer id : students) {
//			System.out.println(student);
//		}
		
		// we have to find something iterable to use
		for (Integer id : students.keySet()) {
			System.out.println(students.get(id));
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}

class Film {
	public String title;
	
	public Film(String title) {
		this.title = title;
	}
}
