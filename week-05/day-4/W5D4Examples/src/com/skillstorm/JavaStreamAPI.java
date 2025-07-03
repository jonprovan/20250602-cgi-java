package com.skillstorm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class JavaStreamAPI {

	public static void main(String[] args) {
		
		/* THE JAVA STREAM API
		 * 
		 * the Stream API has a series of methods for processing collections in a temporary "streamed" format
		 * we can do things with each element, filter elements, etc.
		 * 
		 * BENEFITS
		 * - shorter syntax than manual operations
		 * - fewer internal variables and stored objects
		 * - fewer errors overall
		 * - a more readable series of operations
		 * 
		 * each method in the API requires a lambda function
		 * there are many methods, but we'll focus on these four:
		 * 
		 * forEach
		 * map
		 * filter
		 * reduce
		 * 
		 * once a Stream has been processed, it's gone and CANNOT be processed again
		 * you'd have to create a new Stream from the same elements and process that
		 * 
		 * 
		 * Streams have intermediate and terminal operations
		 * a stream that has gone through either is considered "operated upon"
		 * a stream that has gone through a terminal operation is considered "closed"
		 * in order for stream processing to occur in the way you expect, you MUST finish with a terminal operation
		 * 
		 */
		
		// creating a Stream
		Stream<String> strings = Stream.of("abc", "def", "ghi");
		
		// another more practical way, since we can get back to the original list and re-stream it if we want
		List<String> stringList = new LinkedList<>(Arrays.asList("abc", "def", "ghi"));
		// this creates a stream from the list
		stringList.stream();
		// to create another, we can just call .stream() again
		stringList.stream();
		
		// showing how you can't reprocess a Stream
		// this works the first time
		strings.forEach(str -> System.out.println(str));
		// this throws an IllegalStateException (runtime)
//		strings.forEach(str -> System.out.println(str));
		
		// a list for repeated streaming
		List<Integer> nums = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
		
		/*
		 * forEach -- terminal operation
		 * does something with each element of the stream without returning anything to an outgoing stream
		 * requires a Consumer -- a void function that does whatever we want
		 * you CANNOT return anything in the Consumer
		 */

		nums.stream().forEach(num -> {
			System.out.println("Num * 2 in forEach: " + num * 2);
		});
		
		System.out.println();
		
		/*
		 * map -- intermediate operation
		 * does something with each element of the stream AND returns something to an outgoing stream
		 * requires a Producer -- a non-void function that does whatever we want
		 * you MUST return something in the Producer
		 * 
		 * map must be followed by some sort of terminal operation eventually in order to process
		 * note that processing happens FOR EACH element ALL THE WAY THROUGH before the next element gets processed
		 * 
		 */
		
		nums.stream().map(num -> {
			System.out.println("Num in map: " + num);
			return num * 2;
		}).forEach(num -> {
			System.out.println("Num in forEach: " + num); 
		});
		
		// same thing in a more logical/readable format
//		nums.stream()
//			.map(num -> { System.out.println("Num in map: " + num); return num * 2; })
//			.forEach(num -> System.out.println("Num in forEach: " + num));
		
		System.out.println();
		
		/*
		 * filter -- intermediate operation
		 * looks at each element -- if it meets the criteria, it's returned into the outgoing stream UNALTERED
		 * - if it doesn't meet the criteria, it goes away (is removed from the outgoing stream)
		 * this requires a Predicate -- a function that takes in something, and based on criteria you choose, returns true or false
		 * you MUST return ONLY true or false in the Predicate -- DO NOT return the value you want in the stream
		 */
		
		nums.stream().filter(num -> {
//			if (num < 4)
//				return true;
//			else
//				return false;
			
			// shorthand way of writing the above
			return num < 4;
		}).forEach(num -> System.out.println(num));
		
		// same thing, shorter
//		nums.stream()
//			.filter(num -> num < 4)
//			.forEach(num -> System.out.println(num));
		
		System.out.println();
		
		/*
		 * reduce -- terminal operation
		 * reduces the entire Stream down to a single value/element based on whatever criteria we like
		 * requires a function that takes in two parameters and compares them somehow, then returns one of them (or some value of the right type)
		 * the function MUST return some value
		 * 
		 * the first parameter of reduce (the 0 below) is an initial value
		 * if you don't include it, you have to deal with Optionals (to be discussed later)
		 */
		
		int result = nums.stream().reduce(0, (num1, num2) -> {
			if (num1 > num2)
				return num1;
			else
				return num2;
		});
		
		System.out.println(result);
		
		result = nums.stream().reduce(0, (num1, num2) -> {
			return num1 + num2;
		});
		
		System.out.println(result);
		
		List<Product> products = new LinkedList<>(Arrays.asList(new Product(99.99), new Product(150.23), new Product(0.89), new Product(221.33)));
		
		// accumulating a total price
		double totalPrice = products.stream().reduce(null, (p1, p2) -> {
			if (p1 == null)
				return p2;
			else
				return new Product(p1.price + p2.price);
		}).price;
		
		System.out.println(totalPrice);
		
		// finding the maximum price
		double maxPrice = products.stream().reduce(null, (p1, p2) -> {
			if (p1 == null)
				return p2;
			else
				return (p1.price > p2.price) ? p1 : p2;
		}).price;
		
		System.out.println(maxPrice);
		
		
		// an example of an Optional
		// without a starting value, if the stream is empty, this won't return anything at all
		Optional<Integer> optional = nums.stream().reduce((num1, num2) -> {
			return num1 > num2 ? num1 : num2;
		});
		
		int optionalValue = 0;
		
		if (optional.isPresent())
			optionalValue = optional.get();
		
		System.out.println(optionalValue);
		
		
	}

}

class Product {
	public double price;

	public Product(double price) {
		super();
		this.price = price;
	}

}
