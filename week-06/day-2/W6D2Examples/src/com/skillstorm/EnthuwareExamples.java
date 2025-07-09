package com.skillstorm;

public class EnthuwareExamples {

	public static void main(String[] args) {
		
//		while (false) {
//			// this doesn't compile
//		}
		
		if (false) {
			// but this does, even though it's dead code
		}
		
		ifTest(false);
		
		// this will throw a StackOverflowError -- too many method calls stacking up on top of one another
//		stackOverflow();
		
	}
	
	// better formatting than what's in the example
	public static void ifTest(boolean flag) {
		if (flag)
			if (flag)
				if (flag)
					System.out.println("False True");
				else
					System.out.println("True False");
			else
				System.out.println("True True");
		else
			System.out.println("False False");
	}
	
	public static void stackOverflow() {
		stackOverflow();
	}
}

class FinalTest {
	
	// final properties MUST be initialized in the variable declaration or constructor
	final int i;
	
	public FinalTest() {
		this.i = 5;
	}
	
}
