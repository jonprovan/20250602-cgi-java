package com.skillstorm.extra;

public class ExceptionStuff {

	public static void main(String[] args) {
		
		A a = new A();
		A b = new B();
		A c = new C();
		A d = new D();
		
		// even though our b variable is of type A, the object stored in b IS-A B, so we can cast it as a B
		B bb = (B)b;
		
		// we CANNOT do this, though, because a C IS-NOT-A B -- they have no inheritance relationship
//		bb = (B)c;
		
		// this is okay, though, because D extends B
		bb = (B)d;
		
		// this only goes in one direction -- a parent object CANNOT be cast as a child object
//		bb = (B)a;
		
		Integer i = 5;
		
		String s = "abc";
		
		// for instances where Java KNOWS what's going on, it won't even compile!
//		i = (Integer)s;
		
		// char and some whole number types go back and forth, though, since char is a number under the hood
		throwRTE();

	}
	
	// even if a method specifically throws a RuntimeException and indicates as such, it doesn't need to be handled for compile purposes!!
	public static void throwRTE() throws ClassCastException {
		throw new ClassCastException();
	}

}

class A {}

class B extends A {}

class C extends A {}

class D extends B {}