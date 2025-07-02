package com.skillstorm;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueues {

	public static void main(String[] args) {
		
		/*
		 * PRIORITYQUEUES IN JAVA
		 * 
		 * these sort like any other collection
		 * HOWEVER, they sort on REMOVAL, not insertion
		 * 
		 * the order of elements IN the queue is not predictable, i.e., not sorted OR in the order of insertion
		 * BUT, removal WILL GUARANTEE proper sort order
		 */
		
		// PriorityQueue is a real class, not an interface
		// it is NOT deprecated, unlike Stack
		// so we don't need to use another class to instantiate it
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		pq.offer(9);
		pq.offer(-1);
		pq.offer(24);
		pq.offer(22);
		pq.offer(-32);
		pq.offer(100);
		pq.offer(-2000);
		
		// note that elements in the queue are NOT in sorted order (or insertion order)
		System.out.println(pq);
		
		// however, when we poll the elements, they DO come out in sorted order
		while (!pq.isEmpty()) {
			System.out.print(pq.poll() + " ");
		}
		
		System.out.println();
		
		// you can also provide a Comparator to sort differently, if you like
		PriorityQueue<Integer> pq2 = new PriorityQueue<>(new ReverseIntegers());
		
		pq2.offer(9);
		pq2.offer(-1);
		pq2.offer(24);
		pq2.offer(22);
		pq2.offer(-32);
		pq2.offer(100);
		pq2.offer(-2000);
		
		System.out.println(pq2);
		
		while (!pq2.isEmpty()) {
			System.out.print(pq2.poll() + " ");
		}
		
		System.out.println();
		
		// just like with other sorted collections or sort methods, objects that DO NOT implement Comparable will throw an Exception
//		PriorityQueue<Object> pq3 = new PriorityQueue<>();
//		
//		pq3.offer(new Object());
		
		// you CAN check if an Object has a natural sort order by using instanceof
		System.out.println("abc" instanceof Comparable);
		
	}

}

// our reverse integer sort from yesterday
class ReverseIntegers implements Comparator<Integer> {
	
	public int compare(Integer i1, Integer i2) {
		return i2 - i1;
	}
	
}
