package com.skillstorm;

// Consider the following class :  
public class TestClass6 {    
	public static void main(String[] args) {       
		if (args[0].equals("open"))          
			if (args[1].equals("someone")) // "if" is looking for either a block of code OR a single line; if that's what it gets, a following else
										   // will go with it, like this one -- don't get fooled that the else goes with the first if, indentation aside
				System.out.println("Hello!");
		else System.out.println("Go away "+ args[1]); // this indentation is designed to fool you!!
	} 
}  

// Which of the following statements are true if the above program is run with the command line :  java Test closed