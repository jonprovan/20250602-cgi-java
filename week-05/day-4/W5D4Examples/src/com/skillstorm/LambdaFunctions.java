package com.skillstorm;

import java.util.Arrays;

public class LambdaFunctions {

	public static void main(String[] args) {
		
		/*
		 * LAMBDA FUNCTIONS IN JAVA
		 * 
		 * lambda functions are a short-form way of writing out method functionality
		 * they are often used for code brevity
		 * but, more usefully, they provide us a way of using a method/function as a parameter
		 * we can feed an entire method into another method as a parameter
		 * - Collections.sort(<collection>, <lambda>);
		 * 
		 * You'll use these with threads, streams, Comparator, and many things in Spring Boot
		 * They also show up heavily in JavaScript (JS uses => instead of ->)
		 * 
		 * You DO NOT need to specify a method name
		 * You ALSO do not need to specify a return type
		 * You DO need a parameter list, a method body, and, if you're returning something, to actually return it
		 * 
		 * SYNTAX
		 * No params -- MUST use parentheses -- () -> { //body }
		 * One param -- parentheses are OPTIONAL -- (num) -> { //body } OR num -> { //body }
		 * More than one param -- MUST use parentheses -- (num1, num2) -> { //body }
		 * 
		 * if your body has more than one line/statement, you MUST use braces
		 * () -> { lineOne(); lineTwo(); }
		 * 
		 * if your body has one line, braces are optional
		 * () -> lineOne();
		 * () -> { lineOne(); }
		 * 
		 * if you DON'T use braces, you CANNOT use the return keyword
		 * () -> System.out.printline("Hi"); -- this is a void method that returns nothing
		 * () -> a + b; -- assuming a and b are ints here, this is a method that returns an int
		 * 
		 * if you DO use braces, you MUST use the return keyword like you normally would, unless you don't need it, like the third one below
		 * also, when inside the braces, you must treat each line as a full line of regular code
		 * you NEED to have semicolons -- these blocks are like any other code block (if/else, try/catch, loops, etc.)
		 * () -> { return a + b; }
		 * () -> { if (a == b) return; }
		 * () -> { System.out.printline("Hi"); }
		 */
		
		FuncTwo f2 = () -> { return 1 + 2; };
		int x = f2.add();
		System.out.println(x);
		
		// if the type of the parameters is exactly the same as the method declaration in the interface
		// you DO NOT need parameter types
		// if you're using a subtype, YOU DO
		FuncThree f3 = (a, b) -> { return a + ", " + b; };
		
		String str = f3.concatenate("abc", "def");
		System.out.println(str);
		
		// note that with a single parameter, if you're not using the parentheses, you CANNOT include the type for the parameter
		FuncFour f4 = num -> {
			int[] outputArray = new int[3];
			outputArray[0] = num;
			outputArray[1] = (int)Math.pow(num, 2);
			outputArray[2] = (int)Math.pow(num, 3);
			return outputArray;
		};
		
		System.out.println(Arrays.toString(f4.numSquareAndCube(3)));

	}

}

@FunctionalInterface
interface FuncTwo {
	int add();
}

@FunctionalInterface
interface FuncThree {
	String concatenate(String a, String b);
}

@FunctionalInterface
interface FuncFour {
	// should return an int array containing the original number, its square, and its cube
	int[] numSquareAndCube(int num);
}




