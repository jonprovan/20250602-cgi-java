package com.skillstorm;

public class TestClass1 {
	
	/*
	 * You are writing a class that represents the equation of a straight line: y = mx + c;  
	 * This class has only one method named calcY that takes the value of x and returns the value of y. 
	 * Which variable scopes will you use to ***store*** the values of m and c ***in an instance*** of this class?
	 */
	
	public static void main(String[] args) {
		Calculator calc = new Calculator();
		System.out.println(calc.calcY(3));
	}
	
}

class Calculator {
	
	// these would be stored in THE CLASS, not an instance
//	static int m = 4;
//	static int c = 7;
	
	// these are INSTANCE VARIABLES, which get stored IN THE INSTANCE and could be different for each instance
	int m = 4;
	int c = 7;
	
	public int calcY(int x) {
		
		// also works like this, BUT, these aren't stored ANYWHERE after the method concludes!
//		int m = 4;
//		int c = 7;
		
		return m * x + c;
	}
}
