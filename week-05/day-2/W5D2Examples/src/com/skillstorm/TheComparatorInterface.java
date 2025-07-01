package com.skillstorm;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class TheComparatorInterface {

	public static void main(String[] args) {
		
		/*
		 * THE COMPARATOR INTERFACE
		 * 
		 * unlike Comparable, we DO NOT implement this in the class itself
		 * a Comparator is a third-party object we use to compare elements of a collection or array
		 * 
		 * "Sort this Collection using this Comparator over here"
		 * "Okay, now sort it using this OTHER Comparator, etc."
		 * 
		 * A few ways of using Comparator:
		 * - create a class that implements it, then use an object of that class
		 * - create an anonymous class inline
		 * - implement Comparator's functional interface by just providing the logic for the method we must override
		 */
		
		Book a = new Book("The Stars My Destination", 210);
		Book b = new Book("End Of Burnout", 325);
		Book c = new Book("Dad Jokes", 152);
		Book d = new Book("The 5th Wave", 467);
		Book e = new Book("Elizabeth's Internal Thought Log", 1001);
		
		List<Book> books = new LinkedList<>(Arrays.asList(a, b, c, d, e));
		
		System.out.println(books);
		
		Collections.sort(books, new BookTitleComparator());
		
		System.out.println(books);
		
		Collections.sort(books, new BookPageCountComparator());
		
		System.out.println(books);
		
		// you can override the natural order outlined in the Comparable interface with a Comparator if you want
		// i.e., you can use Comparators EVEN WHEN the class you're sorting ALREADY implements Comparable
		Integer[] nums = { 5, 1, 8, -11, -12 };
		
		System.out.println(Arrays.toString(nums));
		
		// like this, sort will use the natural order
		Arrays.sort(nums);
		
		System.out.println(Arrays.toString(nums));
		
		// like this, sort will use our Comparator instead
		Arrays.sort(nums, new ReverseIntegers());
		
		System.out.println(Arrays.toString(nums));
		
		
		// using an anonymous class (or anonymous inner type)
		// with an anonymous class, we can provide implementation for an interface in-line
		// we don't need to create a separate class declaration
		// this is useful for code we're only going to use ONCE
		
		// this example sorts our books by title WITHOUT using our BookTitleComparator
		// this DOES NOT create a new class we can reuse
		// it provides the required functionality to make Comparator complete
		// by implementing the compare method in-line
		// this sort method is identical functionally to our BookTitleComparator
		Collections.sort(books, new Comparator<Book>() {
			
			public int compare(Book b1, Book b2) {
				return b1.title.compareTo(b2.title);
			}
			
		});
		
		System.out.println(books);
		
		// you can also do this via implementing the functional interface directly -- will revisit with Streams!
		Collections.sort(books, (Book b1, Book b2) -> b1.pageCount - b2.pageCount);
		
		System.out.println(books);
		

	} 

}

// this class will implement Comparator and provide sorting functionality for our Book class
// we MUST override the compare() method, which compares two objects of type Book
class BookTitleComparator implements Comparator<Book> {

	@Override
	public int compare(Book b1, Book b2) {	
		return b1.title.compareTo(b2.title);
	}
	
}

class BookPageCountComparator implements Comparator<Book> {

	@Override
	public int compare(Book b1, Book b2) {	
		return b1.pageCount - b2.pageCount;
	}
	
}

// a class for sorting Integers in reverse order
class ReverseIntegers implements Comparator<Integer> {
	
	public int compare(Integer i1, Integer i2) {
		return i2 - i1;
	}
	
}



class Book {
	
	public String title;
	public int pageCount;
	
	public Book(String title, int pageCount) {
		this.title = title;
		this.pageCount = pageCount;
	}

	@Override
	public String toString() {
		return "\nBook [title=" + title + ", pageCount=" + pageCount + "]";
	}
	
}