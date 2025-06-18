package com.skillstorm;

public class FinalKeyword {

	public static void main(String[] args) {
		
		/*
		 * THE FINAL KEYWORD IN JAVA
		 * 
		 * the final keyword may be applied to a property, method, or class
		 * it has different functionality/meaning depending on which of these it's applied to
		 * 
		 * with a property = once initialized, the value cannot EVER be changed
		 * with a method = it may NOT be overridden in ANY child class
		 * with a class = it may NOT be inherited by ANY subclass
		 * 
		 */
		
//		A a = new A();
//		B b = new B();
//		C c = new C();
//		
//		// we CAN do this, because a B IS AN A
//		A a2 = new B();
//		
//		// we CAN'T do this, because an A is not necessarily a B
////		B b2 = new A();
//		
//		// same idea here
//		A a3 = new C();
////		C c2 = new B();

		C c = new C("Charlie", 12, true);
		System.out.println(c);
		
		// can't do this, because name is final
//		c.name = "Chuck";
		
		c.sayName();
		
		// an example of an existing final property
		double x = Math.PI;
		
	}

}

class A {
	
	// this property is final, so once we initialize it in the constructor, that value is permanent
	public final String name;
	
	public A(String name) {
		super();
		this.name = name;
	}
	
	// this method is final, so it may not be overridden in a child class, grandchild class, etc.
	public final void sayName() {
		System.out.println("My name is " + this.name + ".");
	}

	@Override
	public String toString() {
		return "A [name=" + name + "]";
	}
	
//	an example of an existing final method that cannot be overridden
//	@Override
//	public native Class<?> getClass() {};
	
}

class B extends A {
	
	public int number;
	
	public B(String name, int number) {
		super(name);
		this.number = number;
	}
	
	// this doesn't work, because sayName() in the A class is final and cannot be overridden
//	public void sayName() {
//		System.out.println("My name is " + this.name + " and my number is " + this.number + ".");
//	}

	@Override
	public String toString() {
		return "B [number=" + number + ", name=" + name + "]";
	}
	
}

// this class, because it's final, is the end of the inheritance chain
// NO class may extend from this class
final class C extends B {
	
	public boolean happy;
	
	public C(String name, int number, boolean happy) {
		super(name, number);
		this.happy = happy;
	}

	@Override
	public String toString() {
		return "C [happy=" + happy + ", number=" + number + ", name=" + name + "]";
	}
	
}

// this doesn't work, because the C class is final
// even if we set up our constructor to make it work with C's
//class D extends C {
//	
//}






