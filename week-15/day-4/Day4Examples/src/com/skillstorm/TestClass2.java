package com.skillstorm;

// What will be the result of attempting to compile and run the following class?   
public class TestClass2 {
	
	public static void main(String args[]) {
		int i = 1;
		int[] iArr = { 1 };
		incr(i);					// this passes the value of n (1) to the first overload
		incr(iArr);					// this passes the value of n (a reference to the array object in the heap) to the second overload
		System.out.println("i = " + i + "  iArr[0] = " + iArr[0]);
	}

	public static void incr(int n) {
		n++;						// adjusting the value of the n local variable HAS NOTHING TO DO WITH i!! we ONLY passed in the numerical value
	}

	public static void incr(int[] n) {
		n[0]++;						// however, since n is a reference, adjusting the properties of n (array index values) WILL change them on the heap!
	}
}