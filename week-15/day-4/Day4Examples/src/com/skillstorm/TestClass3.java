package com.skillstorm;

// Consider the following program :  
public class TestClass3 {
	public static void main(String[] args)   {     
		short s = 10; // 1     
		// char c = s; // 2     
		// s = c; // 3 
		
		// System.out.println(Short.MIN_VALUE + " " + Short.MAX_VALUE);
	}
}
/* Identify the correct statements.
 * Line 3 is not valid -- YES
 * Line 2 is not valid -- YES
 * It will compile because both short and char can hold 10 -- NO
 * None of the lines 1, 2, and 3 is valid. -- NO
 * 
 * Reasoning:
 * BOTH are 16-bit values, so you'd think they'd be compatible!
 * 
 * short is signed, meaning it can hold negative values -- from -32768 to 32767
 * char is unsigned, meaning it can ONLY hold zero/positive values -- from 0 to 65535
 * as such, since some values of each type do not fit into the other's range,
 * you CANNOT directly assign one to the other!
 * you CAN cast them, but you'll get weird values if the ingoing value doesn't fit into the other's range 
 */