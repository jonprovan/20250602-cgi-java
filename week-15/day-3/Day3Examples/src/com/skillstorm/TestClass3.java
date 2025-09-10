package com.skillstorm;

// What will happen if you try to compile and run the following program?   
public class TestClass3 {
	
	public static void main(String[] args) {
		calculate(2);
	}

	public static void calculate(int x) {
		
		// it is OKAY to declare local variables without immediately initializing them
		// however, the compiler will complain if you use them somewhere and there's a route through your code that doesn't include the initialization
		String val;
		switch (x) {
			case 2:		// like the other one, without a break statement, we cascade to the default
						// if we DID have a break statement, this code would not compile!
						// because, it would be possible NOT to get to the default case, so val may not have been initialized!
			default:
				val = "def";
		}
		System.out.println(val);
	}
}