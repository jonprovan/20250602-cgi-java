package com.skillstorm;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StacksAndQueues {

	public static void main(String[] args) {
		
		/*
		 * STACKS AND QUEUES
		 * 
		 * Stacks are last-in-first-out (LIFO)
		 * Queues are first-in-first-out (FIFO)
		 * Deques are Queues that can go both directions (can add/remove to either end)
		 * 
		 * there is a Stack object, but don't use it!
		 * use a Deque instead
		 * 
		 * Queue and Deque are interfaces, but they're implemented by LinkedList, so use that for your actual object
		 * 
		 */
		
		// the old Stack object
		// DO NOT USE!!
		Stack<Integer> stack = new Stack<>();
		
		// use push() to add an element
		stack.push(5);
		stack.push(99);
		stack.push(-123);
		
		System.out.println(stack);
		
		// use peek() to view the top element WITHOUT REMOVING IT
		System.out.println(stack.peek());
		System.out.println(stack);
		
		// use pop() to remove and return the element at the top
		System.out.println(stack.pop());
		System.out.println(stack);
		
		
		// Queues
		// we CANNOT instantiate a Queue directly
//		Queue<String> queue = new Queue<>();
		
		// use a LinkedList instead
		Queue<String> queue = new LinkedList<>();
		
		// use offer() to add to the queue
		queue.offer("Meat");
		queue.offer("Potatoes");
		queue.offer("Asparagus");
		
		System.out.println(queue);
		
		// use peek() to view the next element WITHOUT REMOVING IT
		System.out.println(queue.peek());
		System.out.println(queue);
		
		// use poll() to remove and return the next element in the queue
		System.out.println(queue.poll());
		System.out.println(queue);
		
		// peek, pop (for Stacks) and poll ALL return the value
		// so you can store it somewhere if you need to
		String next = queue.poll();
		
		System.out.println(queue);
		System.out.println(next);
		
		
		// Deques
		// these have all the methods in both of the above structures, plus more
		// also an interfaces, so this doesn't work
//		Deque<Character> deque = new Deque<>();
		Deque<Character> deque = new LinkedList<>();
		
		// we still have all the Stack and Queue methods here
		// but we also have specific methods for adding, removing, and peeking at EITHER END
		
		// offerFirst() and offerLast()
		deque.offerLast('a');
		deque.offerLast('b');
		deque.offerLast('c');
		
		System.out.println(deque);
		
		deque.offerFirst('d');
		deque.offerFirst('e');
		deque.offerFirst('f');
		
		System.out.println(deque);
		
		// peekFirst() and peekLast()
		System.out.println(deque.peekFirst());
		System.out.println(deque.peekLast());
		
		System.out.println(deque);
		
		// pollFirst() and pollLast()
		System.out.println(deque.pollFirst());
		System.out.println(deque.pollLast());
		
		System.out.println(deque);
		
		// to use as a queue going right to left
		// use offerLast() and pollFirst()
		deque.offerLast('g');
		System.out.println(deque);
		
		System.out.println(deque.pollFirst());
		System.out.println(deque);
		
		// to use as a queue going left to right
		// use offerFirst() and pollLast()
		deque.offerFirst('h');
		System.out.println(deque);
		
		System.out.println(deque.pollLast());
		System.out.println(deque);
		
		// avoid exceptions by using these methods and not the standard
		// alternatively, you can do checks in advance
		deque.clear();
		
		System.out.println(deque);
		// this throws an exception because the collection is empty
//		deque.pop();
		
		// this DOESN'T!!
		deque.pollLast();
		
		
		// LinkedLists have all these functions even if you just reference them as a LinkedList
		LinkedList<String> list = new LinkedList<>();
		
		// one example
		list.pollFirst();
		
		
		
		

	}

}
