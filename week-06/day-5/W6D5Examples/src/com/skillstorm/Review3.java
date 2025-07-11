package com.skillstorm;

import java.util.concurrent.atomic.AtomicInteger;

public class Review3 {
	
	public static void main(String[] args) {
		
		System.out.println(Cat.catCount);
		
		Cat.initialize();
		
		Cat c1 = new Cat("Moe", "Tabby");
		
		System.out.println(Cat.catCount);
		
		Cat c2 = new Cat("Gina", "Manx");
		
		System.out.println(Cat.catCount);
		
		System.out.println(c1.name);
		
		int x = 5;
		
		switch (x++) {
			case 5:
				System.out.println(x);
		}
		
		// DO NOT WORRY ABOUT OR MEMORIZE THIS!
		// but, you can get some clearer indication of what's happening with this class
		AtomicInteger y = new AtomicInteger(5);
		
		System.out.println(y);
		
		System.out.println(y.incrementAndGet());
		
		System.out.println(y.getAndIncrement());
		
		
	}

}

class Cat {
	
	public static int catCount;
	
	// a static block will run ONCE AND ONLY ONCE when the class (NOT AN OBJECT) is created!
	// think about this like a little mini-method that runs at class creation
	// you CANNOT declare your static properties in here, since everything inside the block is local
	static {
		catCount = 5;
		initialize();
	}
	
	public String name;
	public String breed;
	
	public Cat(String name, String breed) {
		this.name = name;
		this.breed = breed;
		catCount++;
	}
	
	public static void initialize() {
		System.out.println("Initializing...");
		catCount = 0;
	}
	
}
