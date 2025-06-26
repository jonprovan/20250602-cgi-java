package com.skillstorm;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetsInJava {

	public static void main(String[] args) {
		
		/* SETS IN JAVA
		 * 
		 * MOST IMPORTANT -- Sets DO NOT allow duplicates
		 * if you try to add something that's a duplicate, it just won't (no Exception, though)
		 * 
		 * Set is also an interface, so use HashSet or TreeSet
		 * 
		 * HashSet is a basic, unsorted Set
		 * TreeSet is sorted according to natural order
		 */
		
		// can't do this
//		Set<Integer> nums = new Set<>();
		
		Set<Integer> nums = new HashSet<>();
		
		nums.add(6);
		nums.add(0);
		nums.add(-2);
		nums.add(300);
		nums.add(17);
		nums.add(-567);
		nums.add(1000000);
		nums.add(2);
		
		System.out.println(nums);
		
		nums.add(44);
		nums.add(255);
		
		// HashSet DOES NOT guarantee ANY kind of sorting/order, and it may even change over time as you use it
		System.out.println(nums);
		
		// duplicates are automatically NOT added
		// but, no Exception is thrown
		nums.add(300);
		
		System.out.println(nums);
		
		// the add method returns true if the element was added, false if it was a duplicate
		System.out.println(nums.add(111));
		System.out.println(nums.add(300));
		
		System.out.println(nums);
		
		// often, you'll be checking for the presence of a specific value with .contains()
		System.out.println(nums.contains(17));
		
		
		// TreeSet will sort the elements in the Set
		Set<Integer> treeSet = new TreeSet<>();
		
		// this works to add all elements from nums into treeSet
//		for (Integer num : nums) {
//			treeSet.add(num);
//		}
		
		treeSet.add(44);
		
		// or you can feed an entire collection into the addAll method
		// the Collection types MUST match
		// this will also avoid duplicates, as seen with the 44 value we added above, which is also in the nums Set
		treeSet.addAll(nums);
		
		System.out.println(treeSet);
		
		

	}

}
