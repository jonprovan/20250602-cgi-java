package com.skillstorm;

public class StringsInJava {

	public static void main(String[] args) {
		
		/*
		 * STRINGS IN JAVA
		 * 
		 * Strings are arrays of characters (chars) "under the hood"
		 * Strings are Objects, NOT primitives
		 * Must use double-quotes when defining a String
		 * Strings CAN have NO characters -- "" -- this is a valid empty String
		 * String variables can be assigned the value of null
		 * 
		 * Since Strings are arrays, we have access to all sorts of array functionality
		 * 
		 */
		
		String name = "Douglas Fairbanks";
		
		System.out.println(name);
		
		String randomCharacters = "*@()nN>/'";
		
		System.out.println(randomCharacters);
		
		// double quotes require an escape character, as does the backslash, since it's how you escape double-quotes
		String escaped = "I would \\ like to \"escape\", please!";
		
		System.out.println(escaped);
		
		// \n is a new line character, or a line break
		String lineBreak = "First line...\nSecond Line";
		
		System.out.println(lineBreak);
		
		
		// some String methods
		
		// concatenating Strings
		String combined = "abc" + "def";
		
		System.out.println(combined);
		
		// concatenating Strings with things that aren't Strings
		String mixed = "abc" + 123;
		
		System.out.println(mixed);
		
		// this can yield odd results sometimes
		System.out.println("abc" + new Object());
		
		System.out.println(123 + 123 + "abc");
		System.out.println("abc" + 123 + 123);
		
		System.out.println("abc" + new Test());
		
		// .concat()
		String concatenated = "abc".concat(" CONCAT");
		System.out.println(concatenated);
		
		// .toLowerCase()
		System.out.println("ABCDE".toLowerCase());
		
		// .toUpperCase()
		System.out.println("xyz123".toUpperCase());
		
		// .indexOf()
		// returns an int -- the index value of the FIRST occurrence of the char or String
		String fullName = "Marvin Klechlachen";
		
		// can search for individual chars
		int index = fullName.indexOf(' ');
		
		System.out.println(index);
		
		// or longer Strings
		int stringIndex = fullName.indexOf("ach");
		
		System.out.println(stringIndex);
		
		System.out.println(fullName.indexOf("xyz"));
		
		// .replace()
		// replaces ALL instances of the first parameter with the second parameter
		String spacey = "a b c d e";
		
		spacey = spacey.replace(' ', '-');
		
		System.out.println(spacey);
		
		// .trim()
		String spaceyEnds = "     Some Value     ";
		System.out.println(spaceyEnds);
		spaceyEnds = spaceyEnds.trim();
		System.out.println(spaceyEnds);
		
		// .substring()
		String wholeString = "My favorite food is pulled pork.";
		System.out.println(wholeString);
		
		// when just choosing a starting point, it's INCLUSIVE of that index
		String sub = wholeString.substring(10);
		System.out.println(sub);
		
		// when choosing a range, the first parameter is where you start INCLUSIVE
		// the second parameter is where you end EXCLUSIVE
		sub = wholeString.substring(3, 6);
		System.out.println(sub);
		
		// .charAt()
		// we can look at an array slot to see what character is there
		System.out.println("Ford Festiva".charAt(7));
		
		// .split()
		String[] names = "Michael MiddleName Adams".split(" ");
		
		System.out.println(names[0]);
		System.out.println(names[1]);
		System.out.println(names[2]);
		
		// .isEmpty()
		boolean isMyStringEmpty = "".isEmpty();
		System.out.println(isMyStringEmpty);
		
		// chaining operations
		// this will become especially useful later when we get into Streams and the Builder Pattern
		// most of the above operations return the altered value, so we can link them together
		String starting = "    My-Name-Is      Something-Or-Other    ";
		String ending = starting.trim()
								.toLowerCase()
								.replaceFirst("m", "M")
								.replace('-', ' ')
								.replaceFirst("      ", " ")
								.concat(".");
		
		System.out.println(ending);
		
		// equality for Strings can be weird
		// because they're Objects
		System.out.println("abc" == "abc");
		
		String a = new String("abc");
		String b = new String("abc");
		
		System.out.println(a == b);
		
		// the .equals() method is the best practices choice that will work with ALL Strings, however they're declared
		// literals and Objects can be compared to either literals or Objects
		// the String class has an OVERRIDE for the .equals() method that makes it work
		System.out.println(a.equals(b));
	}

}

class Test {
	@Override
	public String toString() {
		return "My Test Object";
	}
}
