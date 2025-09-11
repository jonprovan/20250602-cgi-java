package com.skillstorm;

import java.util.ArrayList;
import java.util.List;

public class TestClass11 {

	public static void main(String[] args) {

		// What will the following code print?
		List s1 = new ArrayList();
		s1.add("a");
		s1.add("b");
		s1.add("c");
		s1.add("a");
		System.out.println(s1.remove("a") + " " + s1.remove("x"));
		
		// .remove() removes the FIRST instance of something, if there's a match, or nothing if there's no match
		// it returns a boolean -- true if it removed something, false if it didn't

	}

}
