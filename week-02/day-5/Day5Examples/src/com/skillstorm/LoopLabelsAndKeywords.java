package com.skillstorm;

public class LoopLabelsAndKeywords {

	public static void main(String[] args) {
		
		/*
		 * LOOP LABELS AND KEYWORDS
		 * 
		 * we have a couple keywords that work with loops to control their flow
		 * 
		 * break -- stop the ENTIRE loop and move on
		 * continue -- stop THIS ITERATION of the loop and move on to the NEXT iteration
		 */
		
		for (int i = 0; i < 100; i++) {
			if (i == 10)
				break;
			
			System.out.println("Index: " + i);
		}
		
		System.out.println("Loop complete!\n");
		
		for (int i = 0; i < 10; i++) {
			if (i % 2 != 0)
				continue;
			
			if (i == 6)
				break;
			
			System.out.println("Even Index: " + i);
		}
		
		System.out.println("Even loop complete!\n");
		
		// loops, like ifs, etc., don't need curly braces if you only have one statement inside them
		for (int i = 0; i < 5; i++)
			System.out.println(i);
			System.out.println("OUTSIDE!\n");
			
		// using loop labels
		// we label each loop with a tag we can call to from another loop (or the same loop)
		// without these labels, we have no way to refer to an outer loop from an inner one
		
		OUTER: for (int i = 0; i < 3; i++) {
			System.out.println("Outer Loop Index: " + i);
			
			MIDDLE: for (int j = 0; j < 3; j++) {
				System.out.println("Middle Loop Index: " + j);
				
				INNER: for (int k = 0; k < 3; k++) {
					if (i == 0)
						continue OUTER;
					
					if (j == 2)
						break MIDDLE;
					
					if (k == 2)
//						break; // break and continue without labels work on the loop they're directly in; in this case, the k loop
						break INNER;
					
					System.out.println("Inner Loop Index: " + k);
				}
			}
			System.out.println("***** Outer Iteration Complete *****");
		}
		
		// the terms in a for loop's setup are OPTIONAL
		
		// this, while perfectly valid and compilable, is an infinite loop, so don't run it!
//		for (;;) {
//			System.out.println("Yikes!");
//		}

	}

}
