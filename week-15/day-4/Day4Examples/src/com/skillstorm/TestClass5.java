package com.skillstorm;

public class TestClass5 {
	
	public static void main(String[] args) {
		
		// What will be the output of the following lines?   
		System.out.println("" + 5 + 6);   // 1 -- 56
		System.out.println(5 + "" + 6);   // 2 -- 56
		System.out.println(5 + 6 + "");   // 3 -- 11
		System.out.println(5 + 6);        // 4 -- 11
		
		// evaluate these from left to right -- as long as you just have numbers, they add normally
		// HOWEVER, when you introduce a String, even an empty one, Java thinks you're concatenating Strings from that point forward
		// if you wanted the 5 and 6 in the first one to add normally before concatenating them with the String, use parentheses around 5 + 6
		
	}

}
