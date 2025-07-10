package com.skillstorm;

import java.util.Arrays;

public class EnthuwareExamples {
	
	static Object d;

	public static void main(String[] args) {
		
		String sample = "abcdefghi";
		
		System.out.println(sample.substring(3, 7));
		
		System.out.println(sample.substring(5));
		
		// this works, because, even though the last slot is index 8,
		// when we use 9 as the stop index, it's going up until the "line" at the beginning of slot 9
		// which is the "line" at the end of slot 8
		System.out.println(sample.substring(3, 9));
		
		// you cannot switch on a double, float, long or boolean
		// best intel says longs have too many options for a switch to be practical
		// while floats and doubles are imprecise
		// booleans are better handled with if/else
		double x = 11e32;
		
//		switch (x) {
//		
//		}
		
		// ALL local variables of ANY type DO NOT get default values, even Objects
		// even null is a value (no reference), but they don't get that, either
		// static variables and instance variables DO get default values
		// also, arrays that are instantiated DO get filled with default values
//		Object d;
		
		Integer[] nums = new Integer[5];
		
//		Integer d;
		
		System.out.println(Arrays.toString(nums));
		
		System.out.println(d);
		
		// varargs
		varargsMethod(5, 6, 7, 8);
		
		// ranges for shorts and chars
		// note that some short values DO NOT fit into the char range, and vice versa
		System.out.println(Short.MIN_VALUE + " " + Short.MAX_VALUE);
		System.out.println((int)Character.MIN_VALUE + " " + (int)Character.MAX_VALUE);
		
		// note the differences here
		char ch = 'a';
		
		// we CAN do this, because Java knows the value of 'a' is 97, which fits into a short
		short sh = 'a';
		
		// however, we CANNOT do this, because it is possibly UNSAFE --
		// the ch variable MAY have been assigned a value that's OUTSIDE of the short's range
		// so Java WILL NOT allow us to do it without casting, etc.
//		sh = ch;
		
		// we MAY get a funny/unexpected value for sh, if ch is out of range, but we CAN do it
		sh = (short) ch;
		
		System.out.println(sh);

	}
	
	// this methods requires at least one int as an argument
	// any amount of additional ints will be collected up into the y varargs array
	public static void varargsMethod(int x, int... y) {
		System.out.println(x);
		System.out.println(Arrays.toString(y));
	}

}
