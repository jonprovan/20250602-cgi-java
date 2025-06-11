package com.skillstorm;

import java.util.Arrays;
import java.util.Comparator;

public class ArraysInJava {

	public static void main(String[] args) {
		
		/*
		 * ARRAYS IN JAVA
		 * 
		 * arrays store things in our program
		 * everything in a given array must be the same data type
		 * arrays can hold primitives or Objects of ANY type
		 * - all other collections (LinkedList, HashMap, TreeSet, etc.) CANNOT hold primitives
		 * 
		 * if we store objects in an array, we can also store any subclasses of that object
		 * 
		 * arrays are fixed-size -- whatever number of "slots" we give it, that's it!
		 * if we want a larger or smaller array, we must create a new array and copy the elements into it
		 * 
		 * arrays are indexed, meaning each slot has a number we can use to access that slot
		 * - this is true for getting values as well as assigning values
		 * - we use square bracket syntax for this, like myArray[9] or tiffinysArray[4]
		 * - indices start at 0 ALWAYS!
		 * 
		 * arrays are contiguous in memory -- all slots are right next to each other
		 * - so, access to array elements is VERY fast, either reading or writing
		 * 
		 * if we store primitives in the array, those values are right there in the array slots
		 * if we store Objects of any kind, the values in the array are references to the objects
		 * - this is just like variables are stored in the stack
		 * 
		 * arrays can store other arrays, or collections of any type, etc.
		 * 
		 * array slots, because they're essentially properties of the array object (like instance variables)
		 * start off with a default value, even if we don't give them one to start
		 * - all number values start with 0 or 0.0
		 * - boolean values start with false
		 * - char values start with the null character, which is \u0000 and looks like a space on the page
		 * - objects of any kind start with null
		 */
		
		// several ways to declare, create, and initialize an array
		
		// declaring one
		// this creates the variable with its type but no actual object, so we don't say the size yet
		int[] nums1;
		
		// you CAN flip the syntax, but I personally find this unclear and confusing
		int nums2[];
		
		// creating one in memory -- we need the size here
		nums1 = new int[5];
		// we CAN reassign the variable to a different array, since the variable is allowed to hold an int[] of ANY size
		// it's just the object itself that's fixed
		nums1 = new int[10];
		
		// we can also use an array literal to declare an array and assign values
		// this MUST be done when the original variable is declared, NOT afterward
		// the newly-created object has a fixed size, just like any other array
		int[] nums3 = { 4, 1, -34, 99, 10000 };
		
		// accessing values
		System.out.println(nums3[2]);
		
		nums3[2] = -35;
		
		System.out.println(nums3[2]);
		
		// reaching for an array index that doesn't exist will throw an ArrayIndexOutOfBoundsException
		// this is an unchecked runtime Exception that the compiler will NOT catch for you, so be careful!
//		System.out.println(nums3[5]);
		
		// arrays have a .length property
		// since the array is ALWAYS the same size, this is not a method, rather a fixed value
		System.out.println(nums3.length);
		
		// printing an array
		// this doesn't quite do what we want, just prints the memory location
		System.out.println(nums3);
		
		// we can loop through the array and grab each value
		for (int i = 0; i < nums3.length; i++) {
			System.out.println("Value at index " + i + ": " + nums3[i]);
		}
		
		// there's also a useful utility method from the java.util.Arrays class
		// prints out all the values in order, enclosed in square brackets
		System.out.println(Arrays.toString(nums3));
		
		// copying arrays
		int[] nums4 = nums3;
		
		System.out.println(Arrays.toString(nums3));
		System.out.println(Arrays.toString(nums4));
		
		nums3[0] = 987;
		
		System.out.println(Arrays.toString(nums3));
		System.out.println(Arrays.toString(nums4));
		
		nums4 = new int[5];
		
		for (int i = 0; i < nums3.length; i++) {
			nums4[i] = nums3[i];
		}
		
		System.out.println(Arrays.toString(nums3));
		System.out.println(Arrays.toString(nums4));
		
		nums4[0] = 111;
		
		System.out.println(Arrays.toString(nums3));
		System.out.println(Arrays.toString(nums4));
		
		// we can also use a utility method to do this
		// the first parameter is the array to copy
		// the second parameter is the length to assign to the new array
		// so, we could make a longer array and copy the values plus insert default values for the remaining slots
		// or, we could make a shorter array, and any extra slots in the original array just get dropped
		nums4 = Arrays.copyOf(nums3, 5);
		
		System.out.println(Arrays.toString(nums3));
		System.out.println(Arrays.toString(nums4));
		
		nums4[0] = 111;
		
		System.out.println(Arrays.toString(nums3));
		System.out.println(Arrays.toString(nums4));
		
		// we can also just clone the other array without changing its length
//		nums4 = nums3.clone();
		
		// arrays with Objects
		Object[] objects = new Object[5];
		
		objects[0] = new Object();
		objects[1] = new Object();
		
		System.out.println(Arrays.toString(objects));
		
		System.out.println();
		
		// some other useful Arrays methods
		int[] numsToSort = { 5, -12, 0, -999, 34, 1000000, -1000000, 476, 3 };
		
		System.out.println(Arrays.toString(numsToSort));
		
		Arrays.sort(numsToSort);
		
		System.out.println(Arrays.toString(numsToSort));
		
		String[] stringsToSort = { "abc", "aaa", "ghi", "aaaa", "xfj", "b" };
		
		System.out.println(Arrays.toString(stringsToSort));
		
		Arrays.sort(stringsToSort);
		
		System.out.println(Arrays.toString(stringsToSort));
		
		// you can create your own sorting methods (content to come later with Comparable and Comparator...)
		// for now, just know that you can sort using custom criteria if natural sort order doesn't work for you or if you're sorting custom objects
		Integer[] numsToSort2 = { 5, -12, 0, -999, 34, 1000000, -1000000, 476, 3 };
		
		Arrays.sort(numsToSort2, (Integer a, Integer b) -> a < b ? 1 : -1);
		
		System.out.println(Arrays.toString(numsToSort2));
		
		// .binarySearch searches through the array and finds the index of the given value
		// first parameter = the array to search, second = the value to look for
		// if it finds it, it returns the index
		// if it doesn't, it returns some random negative number
		int indexOfAaaa = Arrays.binarySearch(stringsToSort, "aaaa");
		System.out.println(indexOfAaaa);
		
		// .compare checks two arrays to see if they have the same type and the same values in the same order
		// if so, it returns 0
		// if not, it returns something other than zero
		int[] a = { 1, 2, 3 };
		int[] b = { 1, 2, 3 };
		
		System.out.println(Arrays.compare(a, b));
		
		Animal one = new Animal("Mammal");
		Animal two = new Animal("Fish");
		Animal three = new Animal("Reptile");
		
		Animal[] aOne = { one, two, three };
		Animal[] aTwo = { one, two, three };
		
		System.out.println(Arrays.compare(aOne, aTwo));

	}

}

class Animal implements Comparable<Animal> {
	
	public String type;
	
	public Animal(String type) {
		this.type = type;
	}

	@Override
	public int compareTo(Animal o) {
		return this.type.compareTo(o.type);
	}
	
}
