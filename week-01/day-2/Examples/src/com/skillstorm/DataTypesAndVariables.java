// the package declaration comes FIRST, before the class declaration
// it also comes before any imports of other packages, classes, methods, etc.
package com.skillstorm;

// this is a class declaration
public class DataTypesAndVariables {
	
	public static void main(String[] args) {
		
		/*
		 * VARIABLES
		 * 
		 * in Java, we store data in variables
		 * the variable can store ANY value, as long as it adheres to the variable's type
		 * Java is strongly-typed, meaning variables can ONLY hold values of the variable's type
		 * at the top of the type chain, we have Object -- a Java class that is the "parent" for ALL other classes
		 * 
		 * a variable declaration includes the indication of the variable's type
		 * 
		 * PRIMITIVES vs. OBJECTS
		 * 
		 * in Primitives...
		 * 
		 * NUMERICAL
		 * (all numerical data types in Java are signed, meaning ranging from some negative to some positive value
		 * 
		 * Whole Numbers
		 * byte -- 8 bits (-128 to 127)
		 * short -- 16 bits (-32768 to 32767)
		 * int -- 32 bits (-2147483648 to 2147483647)
		 * long -- 64 bits (-9223372036854775808 to 9223372036854775807)
		 * 
		 * Decimal Numbers
		 * (use scientific notation to describe wildly large/small numbers)
		 * float -- 32 bits
		 * double -- 64 bits
		 * 
		 * ALPHANUMERICAL
		 * char -- a single character, represented like 'c' or '4' or 'V' or '!' (single-quotes, not double)
		 * *** String -- one or more characters in a row, like "Hello" or "12345" *** NOT A PRIMITIVE!! TECHNICALLY AN OBJECT, double-quotes for these
		 * 
		 * TRUE/FALSE
		 * boolean -- 1 bit, only possible values are false and true
		 * 
		 * 
		 * OBJECTS
		 * Anything else is an Object of some sort:
		 * Java Objects like ArrayList, HashSet, Thread, Stream, etc.
		 * Custom Objects we create, like Animal, Vehicle, DeckOfCards, etc.
		 * Arrays of any kind, like int[], String[], Vehicle[], char[][]
		 * Exceptions and Errors
		 * Wrapper classes like Integer, Character, Float, Boolean, etc.
		 * 
		 */
		
		// here, we're declaring a variable of type int that we're calling x, then initializing that variable with the value 10
		int x = 10;
		
		// we can just declare a variable
		int y;
		
		// this variable has no value, so this throws an Exception
//		System.out.println(y);
		
		// then initialize it later
		y = 100;
		System.out.println(y);
		
//		System.out.println(Byte.MIN_VALUE);
//		System.out.println(Byte.MAX_VALUE);
//		
//		System.out.println(Short.MIN_VALUE);
//		System.out.println(Short.MAX_VALUE);
//		
//		System.out.println(Integer.MIN_VALUE);
//		System.out.println(Integer.MAX_VALUE);
//		
//		System.out.println(Long.MIN_VALUE);
//		System.out.println(Long.MAX_VALUE);
//		
//		System.out.println(Float.MIN_VALUE);
//		System.out.println(Float.MAX_VALUE);
//		
//		System.out.println(Double.MIN_VALUE);
//		System.out.println(Double.MAX_VALUE);
		
		// declaring and initializing some variables
		char letterP = 'p';
		System.out.println(letterP);
		
		// = is the assignment operator, which assigns the value on the right to the variable on the left
		letterP = 'P';
		System.out.println(letterP);
		
		boolean hotOutside = false;
		System.out.println(hotOutside);
		
		double negativeNumber = -123.45;
		System.out.println(negativeNumber);
		
		// Java thinks of decimal numbers as doubles unless we tell it otherwise
		// one way is to put the letter f or F after the number
		float negativeFloat = -123.45f;
		System.out.println(negativeFloat);
		
		// you can also do it by casting
		float negativeFloat2 = (float)-456.78;
		System.out.println(negativeFloat2);
		
		// same issue with whole numbers -- Java thinks of them as ints by default
		int numberGoingIn = 123;
		printByte((byte)numberGoingIn);
		
		// this number is too big for an int, so...
		// can add L to the end to force Java to think of it as a long
		long testLong = 12345678901L;
		
	}
	
	public static void printByte(byte input) {
		System.out.println(input);
	}

}
