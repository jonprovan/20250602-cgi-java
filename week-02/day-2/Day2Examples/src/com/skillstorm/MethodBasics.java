package com.skillstorm;

public class MethodBasics {

	public static void main(String[] args) {
		
		/*
		 * METHOD BASICS IN JAVA
		 * 
		 * "method" and "function" are basically the same concept
		 * they allow us to encapsulate some sort of functionality
		 * 
		 * you need a return type, even if it's void (nothing) -- this is what the method will send back to whatever called it
		 * we need to call to the method to have it run and get its result
		 * 
		 * it can have 0 or more parameters -- values the method "takes in" when we call it
		 * parameters MUST be typed as well, like String name, etc.
		 * 
		 * we need an access modifier -- determines from where we can call this method
		 * 
		 * the body of the method is wrapped in curly braces and contains all the method's functionality
		 * when we call a method, it goes on top of the stack
		 * methods can be both overloaded and overridden
		 * - overloading inside of a class is having the same method name with different parameters
		 * - overriding is having the same name AND parameters in a child class with different functionality
		 * there are other modifiers we can use, like static, final, default, etc.
		 * method naming is camel case, i.e. myGreatMethod and NOT MyGreatMethod or mygreatmethod, etc.
		 * 
		 * methods can use the return keyword
		 * in a method with a return type OTHER THAN void, we use return <value> to send back a value of the proper return type
		 * in a method with a void return type, we can either:
		 * - just not use the return keyword
		 * - use the return keyword with nothing after it
		 */
		
		// static methods can only directly call other static methods without an instance of an object
		// so I'd have do something like this unless I made the method static
//		MethodBasics mb = new MethodBasics();
//		mb.helloMethod("Frank");
		
		// calling a static method
		// note that static methods show up in italics
		helloMethod("SpongeBob");
		
		// for methods with return types, you need to do something with the return
		// here, we're storing it in a variable
		int sum = add(2, 3);
		System.out.println(sum);
		
		// here, we're sending it directly into another method as a parameter
		System.out.println(add(11, 22));

	}
	
	public static void helloMethod(String name) {
		System.out.println("Hello, " + name + "!");
		
		// this is unnecessary, because we're already doing everything we need to do, and it returns when we hit the ending brace
		// return;
	}
	
	public static int add(int a, int b) {
		int sum = a + b;
		// this time, we NEED the return keyword to send back the result
		// the type of the return value MUST match whatever the method says it should be
		return sum;
	}
	
	
	

}













