package com.skillstorm;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class WrapperClasses {

	public static void main(String[] args) {
		/*
		 * WRAPPER CLASSES IN JAVA
		 * 
		 * Collections in Java DO NOT hold primitives
		 * They can only hold Objects
		 * This is a contrast with Arrays, which can hold either
		 * 
		 * Maps also require keys in addition to values
		 * These keys must ALSO be Objects, not primitives
		 * 
		 * So, we need to use Wrapper Classes
		 * Wrapper Classes are Objects that hold values we'd normally think of as primitives
		 * They "wrap" an Object around that primitive value
		 * 
		 * byte -- Byte
		 * short -- Short
		 * int -- Integer ************* DIFFERENT!
		 * long -- Long
		 * 
		 * float -- Float
		 * double -- Double
		 * 
		 * char -- Character *************** DIFFERENT!
		 * 
		 * boolean -- Boolean
		 * 
		 * In most cases, these will auto-box and auto-unbox
		 * Meaning, we don't have to instantiate the Wrapper Class objects manually
		 * We can just stick what looks like a primitive into the collection
		 * 
		 * There's technically a small performance hit when boxing, but not enough to be concerned about
		 */
		
		// using wrappers
		// both of these do the same thing
		// they instantiate an Integer object and fill it with a value of 3
		// the first one is us manually boxing the int
		// the second one is auto-boxing
		// note that the first one is deprecated -- it will still work, but it's unnecessary
		Integer i = new Integer(3);
		Integer j = 3;
		
		// you can auto-box from variable values
		char c = 'C';
		Character c2 = c;
		// and auto-unbox into primitives again
		char c3 = c2;
		
		// primitive types DO NOT work with Collections, so this doesn't work
//		LinkedList<boolean> truesAndFalses = new LinkedList<>();
		
		// we have to do this instead
		LinkedList<Boolean> truesAndFalses = new LinkedList<>();
		
		// but, we can still easily add primitive values to this Collection
		// and the get auto-boxed into Objects
		truesAndFalses.add(false);
		truesAndFalses.add(true);
		
		System.out.println(truesAndFalses);
		
		// note that the key here has to be an Object, too
//		Map<short, String> kids = new HashMap<>();
		Map<Short, String> kids = new HashMap<>();
		kids.put((short)123, "Little Timmy");
		
		// the L after the number is NOT auto-boxing, just casting the 50000 int as a long primitive
		// then, when that value is assigned to the Long object, it gets auto-boxed
		Long l = 50000L;
		
		// note that Java really does think of this object as a Long wrapper object, NOT a primitive
		System.out.println(l.getClass());
		
	}

}
