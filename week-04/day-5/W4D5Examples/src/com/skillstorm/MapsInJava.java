package com.skillstorm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MapsInJava {

	public static void main(String[] args) {
		/*
		 * MAPS IN JAVA
		 * 
		 * Maps are data structures consisting of key-value pairs
		 * We use the keys to "lookup" the values
		 * Keys and values MUST be Objects, but can be ANY kind of object
		 * Maps are typed, so all keys in a given map MUST be the same type
		 * And all values in a given map must be the same type
		 * 
		 * These work as expected with numerical or String keys
		 * However, when we get to custom Object keys, we run into a problem
		 * 
		 * Maps by default are unsorted, unordered, non-iterable
		 * There is a class called TreeMap with sorted keys
		 * However, we'll really be using HashMap most of the time
		 * 
		 * Under the hood, Maps are arrays
		 * But we don't use indices to get access to the different slots
		 * We use the keys we enter
		 * 
		 * Because of the underlying array, we have VERY FAST access to elements inside
		 */
		
		// making one
		// Map is an interface, so we can't do this
//		Map<Integer, String> map = new Map<>();
		Map<Integer, String> map = new HashMap<>();
		
		// it's called a HashMap because Java is using its .hashCode() method to generate the actual key
		// this method returns an int from ANY Object
		System.out.println(new Object().hashCode());
		System.out.println(new Object().hashCode());
		
		// adding things to our Map
		// for .put(), the first param is the key to use, the second is the value
		map.put(17, "Jackson");
		map.put(14, "Rose");
		
		// retrieving a value by its key
		System.out.println(map.get(14));
		
		// putting another value in with the same key will overwrite the original
		// hence, you CANNOT have duplicate keys
		map.put(14, "Rose Bliss");
		
		System.out.println(map.get(14));
		
		// checking by key or value to see if our map contains a certain element
		System.out.println(map.containsKey(13));
		System.out.println(map.containsValue("Rose Bliss"));
		
		// you CAN have duplicate values
		map.put(16, "Jackson");
		
		System.out.println(map.get(16));
		System.out.println(map.get(17));
		
		// removing a key-value pair from the map
		map.remove(17);
		
		System.out.println(map.get(17));
		
		// replacing if present
		// this does NOT create a new entry, because there IS NO entry present at key 15
		map.replace(15, "Rose");
		
		System.out.println(map.get(15));
		
		// but this DOES replace the value at key 14, because it's already in the map
		map.replace(14, "Rose");
		
		System.out.println(map.get(14));
		
		map.put(9, "Tom");
		map.put(8, "Casey");
		System.out.println();
		
		// Maps are NOT iterable, so we CANNOT loop through them outright
		// BUT, you CAN use the keySet to create an iterable set of all the keys
		// you can then use those keys to get access to all the elements in the Map
//		for (String value : map) {}
		
		for (Integer key : map.keySet()) {
			System.out.println(key + " = " + map.get(key));
		}
		
		Map<String, List<String>> faveArtists = new HashMap<>();
		
		List<String> tiffsFaves = new LinkedList<>(Arrays.asList("Bee Gees", "Madonna", "Beach Boys"));
		List<String> jeffsFaves = new ArrayList<>(Arrays.asList("Korn", "Tupac", "Morgan Wallen"));
		List<String> bethsFaves = new LinkedList<>(Arrays.asList("Backstreet Boys", "Usher", "Britney Spears"));
		
		faveArtists.put("Tiffiny", tiffsFaves);
		faveArtists.put("Jeff", jeffsFaves);
		faveArtists.put("Elizabeth", bethsFaves);
		
		System.out.println(faveArtists.get("Jeff"));
		

	}

}





