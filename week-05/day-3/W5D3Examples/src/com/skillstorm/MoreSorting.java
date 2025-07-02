package com.skillstorm;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class MoreSorting {

	public static void main(String[] args) {
		
		// MORE SORTING
		Pokemon a = new Pokemon("Pikachu", "Lightning");
		Pokemon b = new Pokemon("Squirtle", "Water");
		Pokemon c = new Pokemon("Snorlax", "Earth");
		
		// TreeSet still has no duplicates, like any Set
		// however, it is sorted internally
		// this is an "insertion sort", meaning it sorts WHEN YOU INSERT ELEMENTS
		// if you don't provide a Comparator in the parentheses, it uses the natural sort order provided by Comparable
		// if you DO provide a Comparator, it uses that instead
		
//		Set<Pokemon> pokemen = new TreeSet<>();
		Set<Pokemon> pokemen = new TreeSet<>(new PokemonTypeComparator());
		
		pokemen.add(a);
		pokemen.add(b);
		pokemen.add(c);
		
		System.out.println(pokemen);
		
		// for Wrapper classes, Strings, or ANYTHING that already implements Comparable, we don't need to provide a Comparator
		Set<Integer> numSet = new TreeSet<>(Arrays.asList(5, 1, 0, -20, 999, -999));
		System.out.println(numSet);
		
		// the same logic applies to TreeMap, which has sorted keys
		// a regular HashMap has a Set holding its keys, which are unordered and unsorted
		// TreeMap sorts the keys according to natural sort order as provided by Comparable for whatever type the keys are
//		Map<String, Character> grades = new HashMap<>();
		Map<String, Character> grades = new TreeMap<>();
		
		// you can provide Comparator logic or an object, just like the other collections
//		Map<String, Character> grades = new TreeMap<>((String aa, String bb) -> bb.compareTo(aa));
		
		grades.put("Larry", 'C');
		grades.put("Adelaide", 'A');
		grades.put("Manny", 'D');
		grades.put("Wilhelmina", 'B');
		grades.put("Bart", 'F');
		
		// for a HashMap, our keys are NOT sorted
		// but now that it's a TreeMap, the set of keys IS sorted
		System.out.println(grades.keySet());
		

	}

}

class Pokemon implements Comparable<Pokemon> {
	
	public String name;
	public String type;
	
	public Pokemon(String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}
	
	@Override
	public int compareTo(Pokemon other) {
		return this.name.compareTo(other.name);
	}

	@Override
	public String toString() {
		return "Pokemon [name=" + name + ", type=" + type + "]";
	}
	
}

class PokemonTypeComparator implements Comparator<Pokemon> {
	
	@Override
	public int compare(Pokemon p1, Pokemon p2) {
		return p1.type.compareTo(p2.type);
	}
	
}






