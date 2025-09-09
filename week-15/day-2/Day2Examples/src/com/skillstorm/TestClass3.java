package com.skillstorm;

// What will the following program print?  

public class TestClass3 {   
	
	public static void main(String args[]) {       
		int k = 9, s = 5;       
		switch(k) {          
			default : 
				if(k == 10) { // this part would be better served as its own case 10: for k
					s = s*2; 
				} else {             
					s = s+4;             
					break;          
				}          
			case 7 : 
				s = s+3;       
		}       
		System.out.println(s);    
	} 
	
}
