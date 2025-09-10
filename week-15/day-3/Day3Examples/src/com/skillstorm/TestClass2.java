package com.skillstorm;

// What will it print when the following code compiled and run?  

public class TestClass2 {   
	public static int switchTest(int k) {      
		int j = 1;      
		switch(k) {         
			case 1: j++;         
			case 2: j++;       
			case 3: j++;         
			case 4: j++; // this is like saying, if k == 4, start here
			case 5: j++; // but, without break; statements, we cascade through the remaining code until we reach the end of the block
			default: j++;      
		}      
		return j + k;   
	}   
	
	public static void main(String[] args) {      
		System.out.println( switchTest(4) );   
	} 
}