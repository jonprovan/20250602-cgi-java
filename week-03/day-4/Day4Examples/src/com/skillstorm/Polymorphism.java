package com.skillstorm;

public class Polymorphism {

	public static void main(String[] args) {
		
		/*
		 * POLYMORPHISM IN JAVA
		 * 
		 * "many forms" -- objects and methods in Java can have different forms/functionalities
		 * 
		 * 3 main areas that polymorphism affects us:
		 * overloading -- same method name, different parameters
		 * 	-- this is compile-time polymorphism
		 * overriding -- methods in child classes can change functionality of the same methods in parent classes
		 * 	-- this is runtime polymorphism
		 * IS-A Relationships -- an object of a child class can be considered both the child class AND/OR the parent class
		 */
		
		// instance methods require the construction of an object first
		Overload overload = new Overload();
		
		System.out.println(overload.doStuff());
		System.out.println(overload.doStuff("Washed my cat"));
		
		// overriding
		Parent parent = new Parent();
		Child child = new Child();
		
		parent.shout();
		child.shout();
		
		// the reference type DOES NOT dictate which version of the overridden method gets run
		// it is ALWAYS dictated by the actual instantiated object
		// the overridden method will be the one farthest down in the chain
		Parent child2 = new Child();
		
		child2.shout();
		
		// even if a child class DOES NOT have an override in it, we still use previous overrides
		// it will override to the closest "level" to the instantiated object
		Grandchild grandchild = new Grandchild();
		
		grandchild.shout();
		
		// here, we skipped the Grandchild class's override (there is none)
		// but we still overrode the method in the GreatGrandchild class
		Parent greatGrandchild = new GreatGrandchild();
		
		greatGrandchild.shout();

	}

}

class Overload {
	
	// you can overload instance methods as well as static methods
	public String doStuff() {
		return "I did some stuff.";
	}
	
	public String doStuff(String stuff) {
		return "I did some stuff: " + stuff;
	}
	
}

class Parent {
	
	// when overriding, you CANNOT reduce visibility of a method as you go down the chain
	// i.e., the access modifier on an override CANNOT be MORE restrictive than the one on the method it's overriding
	// e.g. -- we can go from private to default, or protected to public
	// but NOT from public to private, or protected to default, etc.
	void shout() {
		System.out.println("Hey, kid, I thought I told you to...GAH!");
	}
	
}

class Child extends Parent {
	
	// we can override the functionality of the shout() method in the Child class
	// in order to be an override and not an overload, it has to match the name and parameters
	// we can use the @Override annotation to make sure we're actually overriding something
	// but it doesn't change the functionality
	@Override
	protected void shout() {
		System.out.println("Aww, Dad...gimme a break!");
	}
	
	// you CAN overload AND override the same class
	// all the usual rules about overloading apply
	// you can mix and match as you see fit
	public void shout(String phrase) {
		System.out.println(phrase);
	}
	
}

class Grandchild extends Child {
	
}

class GreatGrandchild extends Grandchild {
	
	// you can skip a level if you like!
	// we don't have an override in Grandchild, but we can still override the method here
	@Override
	public void shout() {
		System.out.println("Waaaaaaah!");
	}
	
}










