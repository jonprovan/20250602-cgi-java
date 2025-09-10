package com.skillstorm;

// What will be the result of attempting to compile and run the following code?  
public class PromotionTest {
	
	public static void main(String args[]) {
		int i = 5;
		float f = 5.5f;
		double d = 3.8;
		char c = 'a';
		
		if (i == f) // for equality, even when comparing whole numbers and decimals, there is no "lopping off" of decimals, so this is false!
			c++;
		
		// comparing adding first, then casting vs. casting first, then adding
		// (int) (f + d) keeps the decimals when adding, then chops it after, so 9.3 goes to 9
		// (int) f + (int) d chops the decimals FIRST, then adds, so 5.5 goes to 5, 3.8 goes to 3, then they add to 8
		// so this is false, too!
		if (((int) (f + d)) == ((int) f + (int) d))
			c += 2;
		
		System.out.println(c);
	}
}