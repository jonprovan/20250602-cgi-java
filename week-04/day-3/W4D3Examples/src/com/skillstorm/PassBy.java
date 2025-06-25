package com.skillstorm;

public class PassBy {

	public static void main(String[] args) {
		
		/*
		 * PASSING VALUES IN JAVA
		 * 
		 * "Pass By Value" vs. "Pass By Reference"
		 * 
		 * This is a bit of misnomer
		 * ALL things passed to methods are values
		 * HOWEVER, for primitives, that value is a direct value (10, true, 'c', etc.)
		 * For OBJECTS, that value is a reference to an object on the heap
		 * 
		 */
		
		// the x variable directly holds a value of 10, which is an int
		// this value lives in the stack, not the heap
		int x = 10;
		
		System.out.println(x);
		
		manipulateNumber(x);
		
		System.out.println(x);
		
		
		// the numHolder variable, on the other hand, holds a value that is the address of the new NumberHolder object
		// the object lives on the HEAP
		// what lives on the stack is ONLY the address, NOT the object
		NumberHolder numHolder = new NumberHolder(20);
		
		System.out.println(numHolder.num);
		
		// when we pass numHolder's value, which is a reference/address to the method
		// BOTH the numHolder variable AND the nh variable in the method point to the SAME OBJECT on the heap
		// therefore, changing that object's properties in one place will change them in the other
		manipulateNumberHolder(numHolder);
		
		System.out.println(numHolder.num);
		
		// like the previous example, we pass in the reference/address
		// even once the reference inside the nullIt method gets nulled out
		// the numHolder variable STILL HOLDS the original reference, so the object still exists
		nullIt(numHolder);
		
		System.out.println(numHolder.num);
		
		// similar to this, where three still points to the object, even though the other references were removed
		Object one = new Object();
		Object two = one;
		Object three = one;
		
		one = null;
		two = null;
		
		System.out.println(three);
		
		
		

	}
	
	public static void manipulateNumber(int num) {
		num += 10;
	}
	
	// this method changes the value in the object itself
	// so any references pointing to that object will reflect the new value
	public static void manipulateNumberHolder(NumberHolder nh) {
		nh.num += 10;
	}
	
	
	// this method nulls out ONLY the nh reference to the object
	// ANY other references will still point to the original, not-nulled-out Object
	public static void nullIt(NumberHolder nh) {
		nh = null;
	}
	
	

}

class NumberHolder {
	public int num;
	
	public NumberHolder(int num) {
		this.num = num;
	}
}





