package com.skillstorm;

// What will the following code print?  
public class BreakTest {
	
	public static void main(String[] args) {
		int i = 0, j = 5;
		lab1: for (;; i++) {			// this syntax is valid -- you can have entries in all, some, or none of the three loop areas (;;)
				for (;; --j)			// this internal loop never ends unless we manually break it, which we never do!
					if (i > j)
						break lab1;		// eventually, we manually break the OUTER loop (lab1), which stops BOTH loops wherever they are
										// but, since we never get past the first iteration of the outer loop, i never increments!!
			  }
		
		System.out.println(" i =" + i + " , j = " + j);
	}
}