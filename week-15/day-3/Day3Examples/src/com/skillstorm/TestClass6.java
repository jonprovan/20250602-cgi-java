package com.skillstorm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestClass6 {
	
	public static void main(String[] args) {
		
		// Identify the valid for loop constructs assuming the following declarations (CHOOSE 2):
		//   Object o = null;
		//   ArrayList c = //valid ArrayList object.
		//   int[] ia = //valid array
		
		/*
		 * for (o : c) {}														-- doesn't work, no type for local variable
		 * for (final Object o2 : c) {}											-- final is okay here, as it's recreated for each iteration
		 * 																		-- also, ANY object can be cast as Object, so that works, too!
		 * for (int i : ia) {}													-- straightforward enhanced for loop with correct type
		 * for (Iterator it : c.iterator()) {}									-- can't look for Iterators within the Iterator...doesn't make sense
		 * for (int i = 1; i <= ia.length; i++) { System.out.println(ia[i]); }	-- this will skip the first element, then throw an AIOOB Exception
		 * 																		   when it reaches the index matching the length (due to <=)
		 */
		
		ArrayList<Integer> nums = new ArrayList<>(List.of(1, 2, 3, 4, 5));
		Iterator<Integer> iterator = nums.iterator();
		
		// can't do this, because what nums.iterator() returns is a single object!
//		for (Iterator i : iterator) {}
		
		// you have to do something like this:
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		// same thing here -- can't loop through a single object
		Integer integer = 5;
//		for (Integer i : integer ) {}

		
	}

}
