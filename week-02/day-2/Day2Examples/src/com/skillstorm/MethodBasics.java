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
		
		checkTopping("Anchovies");
		
		System.out.println(randomCutoff());
		
		// note that we're not calling squareIt() here, just stageOne, and stageOne calls squareIt
		// each method called by this method must resolve before this method can complete
		// each method gets added to the top of the stack until it returns and resolves
		stageOne(5, "     Pearl Jam     ", true);
		
		
		// instance methods
		
		// can't do this
//		raiseHand();
		
		// can't do this, either
//		Student.raiseHand();
		
		// CAN do this, because this method is static, belongs to the class, and exists before an object is instantiated
		Student.joinClass();
		
		// we need to create an object from the Student class first, then call the method on the object
		Student s = new Student();
		
		// calling the method on the object
		s.raiseHand();
		

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
	
	// wherever you see the return keyword, method processing will end there
	// we may want to "get out" of a method at various points and/or before later steps, etc.
	// Java will tell you if you have a branch from which you're not returning if required
	public static void checkTopping(String topping) {
		if (topping.equals("Pineapple")) {
			System.out.println("Yuck!");
			return;
		} else if (topping.equals("Anchovies")) {
			System.out.println("Maybe if I'm ravenous...");
			return;
		}
			
		System.out.println("DELISH!!");
	}
	
	// these ifs are called guard clauses
	// they allow us to rule out certain brackets of possibility
	public static String randomCutoff() {
		double random = Math.random();
		
		if (random > 0.666)
			return "Greater than two-thirds";
		
		if (random > 0.333)
			return "Between one- and two-thirds";
		
		return "Less than one-third";
	}
	
	// this method calls three other methods
	public static void stageOne(int a, String b, boolean c) {
		
		// in order to print, we need to run squareIt() first
		System.out.println("My int squared is: " + squareIt(a));
		
		// same with validateString()
		System.out.println("My favorite band is: " + validateString(b));
		
		// here, stageTwo() has to call another method as well
		System.out.println("My double is: " + stageTwo(c));
		
	}
	
	public static int squareIt(int a) {
		return (int)Math.pow(a, 2);
	}
	
	public static String validateString(String b) {
		b = b.trim();
		if (b.equals("Pearl Jam"))
			return b;
		else
			return "WRONG ANSWER";
	}
	
	// this needs to call returnChar() in order to complete
	public static double stageTwo(boolean c) {
		if (returnChar(c) == 'X')
			return 1.0;
		else
			return 0.0;
	}
	
	public static char returnChar(boolean c) {
		if (c)
			return 'X';
		else
			return 'Y';
	}
	
	

}

class Student {
	
	// an instance method
	public void raiseHand() {
		System.out.println("Hey, um...I have a question.");
	}
	
	// a static or class method
	public static void joinClass( ) {
		System.out.println("Joined!");
	}
	
}













