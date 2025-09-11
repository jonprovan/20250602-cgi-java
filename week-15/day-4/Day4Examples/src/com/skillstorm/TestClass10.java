package com.skillstorm;

// Given:
import java.util.*;

public class TestClass10 {
	
    public static void main(String[] args) throws Exception {
        ArrayList<Double> al = new ArrayList<>();		// no primitive types allowed in Collections (Map, Set, List)

        //INSERT CODE HERE
        
     }
}
// What can be inserted in the above code so that it can compile without any error?

/*
 * al.add(111);									// doesn't work, because the method expects a double and whole numbers are ints by default
 * System.out.println(al.indexOf(1.0));			// these two work, because indexOf and contains both take Objects of ANY kind
 * System.out.println(al.contains("string"));
 * Double d = al.get(al.length);				// Lists don't have a length property, they have a size() method
 */
