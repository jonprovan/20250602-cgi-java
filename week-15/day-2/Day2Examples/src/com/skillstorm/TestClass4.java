package com.skillstorm;

// What will be the result of attempting to compile and run the following program?  
public class TestClass4 {    
	
	public static void main(String args[]) {       
		boolean b = false;       
		int i = 1;       
		do {          
			i++ ;       
		} while (b = !b); // ONE: watch for these assignments where you expect a ==, and TWO: assignment operators RETURN the assigned value 
						  // if b were NOT a boolean, this would NOT work here!!
		System.out.println( i );  
		
		int g;
		int h;
		
		// assignment operations return the value assigned, so "h = 10" returns 10, which then can be assigned to g
		g = h = 10;
		System.out.println(g);
	} 
	
}