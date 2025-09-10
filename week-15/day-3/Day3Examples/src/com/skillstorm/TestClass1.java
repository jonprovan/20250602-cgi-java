package com.skillstorm;

// What will be the output if you run the following program?   
public class TestClass1 {    
	public static void main(String args[]) {       
		int i;      // by declaring these outside the loop, we have access to them after the loop is complete 
		int j;       
		for (i = 0, j = 0; j < 1; ++j, i++) {      // it is OKAY to declare or initialize multiple variables or take multiple actions after iterations    
			System.out.println( i + " " + j );
		}    
		// if the variables were declared inside the loop like is typical, this line WOULD NOT compile!
		System.out.println( i + " " + j );    
	} 
}