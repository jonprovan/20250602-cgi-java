package com.skillstorm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class JavaReview {

	public static void main(String[] args) {
		
		List<Integer> nums = new LinkedList<>(List.of(1, 2, 3, 4, 5));
		
		// in Java, you CANNOT run Stream functions (forEach, map, filter, reduce) on a List or array
		// you MUST run them on a Stream
		// and, map/filter return another Stream, not a usable array/List
		Stream<Integer> numsResult = nums.stream().map(num -> {
			return num * 2;
		});
		
		numsResult.forEach(num -> {
			System.out.println(num);
		});
		
		System.out.println(nums);
		
		// increments/decrements and ternaries
		int x = 1; // 1 -> 2
		int y = 2; // 2 -> 1
		int z = x++; // 1 -> 0 -> 1
		int a = --y; // 1
		int b = z--; // 1 -> 2
		b += ++z;
		
		int answ = (x > a) ? (y > b) ? y : b : (x > z) ? x : z;
		// you can either start with the first boolean question to determine whether you need to evaluate the others
		// then look for internal ternaries (like y > z ? y : b) and evaluate those
		System.out.println(answ);

		
	}

}
