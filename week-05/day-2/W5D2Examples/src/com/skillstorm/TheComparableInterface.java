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
		Person b = new Person("Marla", 36, bKids);
		
		String[] cKids = { "Gina", "Al", "Zola", "Doug" };
		Person c = new Person("Louise", 75, cKids);
		
		
		Person[] peopleArray = { a, b, c };
		List<Person> people = new LinkedList<>(Arrays.asList(a, b, c));
		
		System.out.println(people);
		
		// these actions no longer stop the program, because our custom class implements Comparable
		Arrays.sort(peopleArray);
		Collections.sort(people);
		
		System.out.println(people);
		
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
	public int compareTo(Person p) {
		return 0;
	}
	
}



