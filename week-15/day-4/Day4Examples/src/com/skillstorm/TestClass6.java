package com.skillstorm;

public class TestClass6 {

	public static void main(String[] args) {
		
		/*
		 * Which of the following are valid declarations?
		 * 
		 * int a = b = c = 100;				// this requires b and c to exist already -- they're not being declared here
		 * 
		 * int a, b, c; a = b = c = 100;	// declaring multiple variables using commas is fine!
		 * 
		 * int a, b, c = 100;				// even if one or more of them are getting default values
		 * 
		 * int a = 100, b, c;
		 * 
		 * int a = 100 = b = c;				// same problem as the first, plus, we're trying to assign a value to 100
		 */
		
		// if b and c existed already, the first one would work!
		int b;
		int c;
		
		int a = b = c = 100;
		
		// the last one still doesn't work, even if b and c exist!
		// int a = 100 = b = c;

	}

}
