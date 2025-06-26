package com.skillstorm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListsInJava {

	public static void main(String[] args) {
		
		/*
		 * LISTS
		 * 
		 * List is an interface -- can't instantiate one directly
		 * We usually instantiate it with an ArrayList or a LinkedList
		 * Lists are ordered -- the order things are in the list will be maintained
		 * 
		 * ArrayLists and LinkedLists have much common functionality
		 * 
		 * ArrayList
		 * - has an array "under the hood"
		 * - however, it is resizable
		 * - when we reach the limits of the underlying array, it will create a new array with 50% more space
		 * - this happens automatically, and you don't need to worry about it
		 * - element access is constant-time (O(1)), just like an array
		 * - there IS a performance hit when the array is resizing
		 * - there's ALSO a performance hit when inserting/removing elements anywhere except the end
		 * - we must copy over ALL other elements to adjust
		 * 
		 * LinkedList
		 * - no array under the hood
		 * - this has a series of nodes
		 * - each node contains three things -- a value, a pointer to the next node, and a pointer to the previous node
		 * - LinkedLists in Java are doubly-linked, so they have pointers in both directions
		 * - in some other programs, they're only singly-linked, with just a pointer to the next node
		 * - element access is SLOW -- the program must walk through the links, from one to the next
		 *   until it finds the one you want
		 * - HOWEVER, insertion/deletion are VERY FAST -- no copying/shifting is necessary, just break the links and reattach
		 * - the previous pointer at the head, and the next pointer at the tail, point to null
		 */
		
		// instantiating an ArrayList
		// Collections are typed in the angle brackets -- <>
		// you MUST use Objects, NOT primitives
		ArrayList<Integer> al = new ArrayList<>();
		List<Integer> al2 = new ArrayList<>();
		
		// can't do this, because it's an interface
//		List<Integer> l = new List<>();
		
		// adding elements to the ArrayList
		// note that they stay ordered but are not sorted in any way
		al.add(3);
		al.add(10);
		al.add(-34);
		al.add(99);
		
		System.out.println(al);
		
		// you can also add at a specific index
		// first param is the index, second is the value
		al.add(3, 255);
		
		System.out.println(al);
		
		
		// accessing a value (does not remove it)
		System.out.println(al.get(1));
		
		System.out.println(al);
		
		
		// removing a value
		// this can be done via index, like this
		// it completely removes the element and shifts all the other elements over to fill the gap
		Integer removed = al.remove(1);
		
		// the remove method returns the value at that index
		System.out.println(removed);
		
		System.out.println(al);
		
		
		// you can also remove by the value itself
		// it will look through for the first instance of that value, then remove that slot
		ArrayList<String> stringList = new ArrayList<>();
		
		stringList.add("Coffee");
		stringList.add("Tea");
		stringList.add("Milk");
		
		System.out.println(stringList);
		
		stringList.remove("Tea");
		
		System.out.println(stringList);
		
		// we can do this with our Integer list, too, but we have to cast the int value so it doesn't look for an index
		al.remove((Integer)255);
		
		System.out.println(al);
		
		
		// checking to see if the list contains a value
		System.out.println(stringList.contains("Milk"));
		
		
		// emptying out the list
		stringList.clear();
		
		System.out.println(stringList);
		
		
		// getting the index of a certain value, i.e. searching for it
		System.out.println(al.indexOf(99));
		
		
		// getting the length of the list
		// List DO NOT have a length property like arrays
		System.out.println(al.size());
		
		
		// you can sort, but we'll get into this later
		al.sort(null);
		
		System.out.println(al);
		
		al.sort((Integer a, Integer b) -> b - a);
		
		System.out.println(al);
		
		
		// all the above methods work with LinkedList as well!
		// since they are part of the List interface, which BOTH implement
		LinkedList<String> ll = new LinkedList<>();
		
		// however, LinkedLists have other methods that are specific to other interfaces LinkedList implements
		// like Queue and Deque
		// we'll address these later this week!
		ll.offerFirst("Marlon");
		System.out.println(ll.pollLast());
		

	}

}







