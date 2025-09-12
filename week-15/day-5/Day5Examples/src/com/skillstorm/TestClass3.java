package com.skillstorm;

public class TestClass3 {

	public static void main(String[] args) {
		
		// What is the result of executing the following fragment of code:   
		boolean b1 = false; 
		boolean b2 = false;
		
		if (b2 != b1 = !b2) {   			// this doesn't work because of the order of operations
											// != operations happen BEFORE assignment operations
											// so, this first turns into false = !b2 after the != resolves
											// and you can't assign a value to a boolean value -- a boolean variable, yes, but a value, no
											// if you put parentheses around b1 = !b2 to force the assignment FIRST, it works fine!
			System.out.println("true"); 
		} else {    
			System.out.println("false"); 
		}

	}

}
