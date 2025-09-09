package com.skillstorm;

public class Test {     
	public static void main(String args[]) {  
		
		// loop labels (A, B, C) can be ignored, as they're NEVER used
		// looking at the output, we just need to determine how many times the inner loop runs
		// since the break condition has nothing to do with i,
		// once we figure out how many times the inner loop runs when i = 0, we just double that to get the overall answer
		// since the outer loop runs twice
		// remember that, without a loop label, break/continue will apply to the SPECIFIC LOOP THEY ARE DIRECTLY IN!! (inner here)
		
		int c = 0;         
		A: for(int i = 0; i < 2; i++) {             
			B: for(int j = 0; j < 2; j++) {                 
				C: for(int k = 0; k < 3; k++) {                     
					c++;                     
					if(k>j) 
						break;                 
				}             
			}         
		}         
		
		System.out.println(c);     
		
	} 
}