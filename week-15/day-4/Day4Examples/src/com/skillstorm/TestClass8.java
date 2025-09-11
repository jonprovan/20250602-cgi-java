package com.skillstorm;

public class TestClass8 {
	
	public static void main(String[] args) {
		
		ifTest(true);
		ifTest(false);
		
	}
	
	// Consider the following method:  
	public static void ifTest(boolean flag) {  
		
		// remember that if/else statements "join" together, so an else immediately following an if will go with that if,
		// not some other one in the nested structure
		
		if (flag)   
			if (flag)   
				if (flag)									// this if and its else are considered one "block" and don't need braces to compile     
					System.out.println("False True"); 		// unless there were more than one statement in either the if or else
				else          
					System.out.println("True False");    
			else         
				System.out.println("True True");    
		else        
			System.out.println("False False"); 
	}   
}

	// Which of the following statements are correct ?
	