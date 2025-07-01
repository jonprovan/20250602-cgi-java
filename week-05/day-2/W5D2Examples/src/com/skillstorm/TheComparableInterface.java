package com.skillstorm;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class TheComparableInterface {

	public static void main(String[] args) {
		
		/* THE COMPARABLE INTERFACE
		 * 
		 * The Comparable interface allows us to compare "this" object to another object of the same type
		 * and discover which is considered "less" and which is considered "more"
		 * for the purposes of sorting
		 * 
		 * Whatever reasoning we determine for what makes an object "more" or "less" is fine!
		 * Totally up to you!
		 * 
		 * Usually, it's based on some sort of property
		 * If it were a Person class
		 * - could be their .name in alpha order
		 * - could be their .age lowest to highest (or highest to lowest)
		 * - could be the number of children they have in their .children String[]
		 * - could be a combination of these properties, like sort by age, then if age is the same, sort by name, etc.
		 */
		
		String[] aKids = { "Marcie", "Biff", "Charlene" };
		Person a = new Person("Robert", 88, aKids);
		
		String[] bKids = { "Louis" };
		Person b = new Person("Marla", 75, bKids);
		
		String[] cKids = { "Gina", "Al", "Zola", "Doug" };
		Person c = new Person("Marla", 36, cKids);
		
		
		Person[] peopleArray = { a, b, c };
		List<Person> people = new LinkedList<>(Arrays.asList(a, b, c));
		
		System.out.println(people);
		
		// these actions no longer stop the program, because our custom class implements Comparable
		Arrays.sort(peopleArray);
		Collections.sort(people);
		
		// now that our Person class implements Comparable, the collection gets sorted properly
		// comment/uncomment the different logic in the compareTo method to see the different sort orders
		// currently, it sorts by name, and if the names match, it sorts those by age
		
		System.out.println(people);
		
		// why do we need to return an int from compareTo, and what does it mean?
		Integer i = 45;
		Integer j = 0;
		
		// if an object is "more" than another object, compareTo should return a positive integer
		// if it's "less," it should return a negative integer
		// if it's "the same," it should return 0
		System.out.println(i.compareTo(j));
		System.out.println(j.compareTo(i));
		System.out.println(i.compareTo(i));
		
		// sorting speed test
		List<Double> doubles = new LinkedList<>();
		
		for (long l = 0; l < 1000000; l++) {
			doubles.add(Math.random());
		}
		
		long startTime = System.nanoTime();
		
		Collections.sort(doubles);
		
		long endTime = System.nanoTime();
		
		System.out.println("Time it takes to sort a million random doubles:");
		System.out.println((double)(endTime - startTime) / 1000000000);
		
	}

}

// to implement Comparable, add it to your class declaration
// the type after the name of the interface should usually be the same type as the class itself
// because we intend to compare one Person to another
// we must now implement Comparable's compareTo() method
class Person implements Comparable<Person> {
	public String name;
	public int age;
	public String[] children;
	
	public Person(String name, int age, String[] children) {
		this.name = name;
		this.age = age;
		this.children = children;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", children=" + Arrays.toString(children) + "]";
	}

	@Override
	public int compareTo(Person other) {
		// comparing by age
//		if (this.age > other.age)
//			return 1;
//		else if (this.age < other.age)
//			return -1;
//		else
//			return 0;
		
		// we can shorthand this substantially
//		return this.age - other.age;
		
		// comparing by name
		// for Strings, we can use the String class's compareTo method
		// String ALSO implements Comparable (it has a natural sort order), so we can lean on that
		// its compareTo method returns an int, so we can use the natural sort order or flip it if we want
//		return this.name.compareTo(other.name);
		
		// comparing number of children
		// you'd need some logic in here to protect against a null children array
//		return this.children.length - other.children.length;
		
		// combining different sort criteria
		if (this.name.compareTo(other.name) == 0)
			return this.age - other.age;
		else
			return this.name.compareTo(other.name);
		
		// each of these natural sort orders is kinda on its own
		// we can't choose to sort by name sometimes (in a given class) and by age other times
		// in order to get around this, we need to work with the Comparator interface
		
	}
	
}



