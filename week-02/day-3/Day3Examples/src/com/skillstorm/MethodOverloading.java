package com.skillstorm;

public class MethodOverloading {

	public static void main(String[] args) {
		
		/*
		 * METHOD OVERLOADING IN JAVA
		 * 
		 * in general, overloading is when we have two methods within the same scope
		 * with the same exact name but different parameters
		 * - different number of parameters
		 * - same number of parameters but different types
		 * - same number AND types but a different order
		 * 
		 * this is called compile-time polymorphism
		 * - as opposed to runtime polymorphism, which is method overriding (content coming in Week 3)
		 * 
		 * THINGS THAT DON'T MATTER FOR OVERLOADING
		 * (i.e., things that don't distinguish one method from another
		 * - the access modifier
		 * - the return type
		 * - whether or not it's static, final, default, etc.
		 * 
		 * WHY IS THIS USEFUL?
		 * Ease of understanding the interface/functionality with an object/class
		 * - easier to use (example) add() with whatever numbers/types we want
		 *   rather than having to choose between addInts(), addDoubles(), addShorts(), and so on
		 * 
		 * 
		 */
		
		int sum = add(6, 8);
		
		System.out.println(sum);
		
		sum = add(4, 11, 90);
		
		System.out.println(sum);
		
		System.out.println(add("abc", "def"));
		
		System.out.println(add("123", 456));
		
		System.out.println(add(789, "012"));
		
		

	}
	
	// the only things that matter are add(int __, int __)
	public static int add(int a, int b) {
		System.out.println("Using our add(int __, int __) Method Overload");
		return a + b;
	}
	
	// different number of parameters
	public static int add(int a, int b, int c) {
		System.out.println("Using our add(int __, int __, int __) Method Overload");
		return a + b + c;
	}
	
	// different parameter types (same number)
	public static String add(String a, String b) {
		System.out.println("Using our add(String __, String __) Method Overload");
		return a + b;
	}
	
	public static String add(String a, int b) {
		System.out.println("Using our add(String __, int __) Method Overload");
		return a + b;
	}
	
	// same number of parameters and same types but a different order
	public static String add(int a, String b) {
		System.out.println("Using our add(int __, String __) Method Overload");
		return a + b;
	}
	
	// can't do this, either, even though the previous one is static and this one is not
	// this is because of the quirk that you can call a static method on an instance (even though you shouldn't)
//	public int add(int a, int b) {
//		return a + b;
//	}
	
	
	
	// these are not distinct based only on access modifier
//	public static void example() {};
//	private static void example() {}; 
	
	// these are not distinct either based only on return type
//	public static void example() {}
//	public static int example() { return 1; };

}
