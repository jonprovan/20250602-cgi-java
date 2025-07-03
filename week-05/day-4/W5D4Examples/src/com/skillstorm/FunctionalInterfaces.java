package com.skillstorm;

public class FunctionalInterfaces {

	public static void main(String[] args) {
		
		/*
		 * FUNCTIONAL INTERFACES
		 * 
		 * a functional interface in Java is an interface with EXACTLY ONE abstract method
		 * you MUST have one, and you MUST NOT have any others
		 * 
		 * many areas in Java use these
		 * usually, they're places where you require some sort of custom functionality in a standard structure
		 */
		
		// can't do this
//		FuncOne f1 = new FuncOne();
		
		// we CAN do this
		// we provide the class body, including the implementation of the abstract method, inline
		// this uses an anonymous inner type/class to instantiate the object
		FuncOne f1 = new FuncOne() {
			
			@Override
			public void doSomething() {
				System.out.println("Hello from my FuncOne f1 object!");
			}
		};
		
		// this DIFFERENT object has DIFFERENT implementation, even though BOTH are FuncOne objects
		FuncOne f2 = new FuncOne() {
			
			@Override
			public void doSomething() {
				System.out.println("Hello from my other FuncOne object, called f2!");
			}
		};
		
		f1.doSomething();
		f2.doSomething();
		
		// note that these show up differently with getClass
		// something is NOT the same about them, even though they're both implementing the same FuncOne interface
		System.out.println(f1.getClass());
		System.out.println(f2.getClass());
		
		// this does the same sort of thing, using a lambda function
		FuncOne f3 = () -> System.out.println("Hello from f3!");

	}

}

// this annotation is NOT required in order to make a functional interface
// but, it will help by making the interface not compile if you have more than one abstract method
@FunctionalInterface
interface FuncOne {
	
	// this is our one abstract method
	void doSomething();
	
	// this is not allowed, because then we'd have TWO abstract methods
//	void doSomethingElse();
	
	// this IS allowed, because it is not abstract
	default void doSomethingElseByDefault() {};
	
}
