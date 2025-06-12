package com.skillstorm;

import java.util.Arrays;
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
		Scanner scan = new Scanner(System.in);
		
		System.out.println("\nPlease Enter Your Name:");
		
		String[] names = { "Elizabeth", "Jeff", "Jon", "Michael", "Tiffiny" };
		
		boolean redo = false;
		String result = "";
		
		do {
			String input = scan.nextLine().trim();
			if (Arrays.binarySearch(names, input) < 0) {
				redo = true;
				System.out.println("Please try again:");
			} else {
				redo = false;
				result = input;
			}
		} while (redo);
		
		System.out.println("Your name is: " + result);
		
		scan.close();

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
