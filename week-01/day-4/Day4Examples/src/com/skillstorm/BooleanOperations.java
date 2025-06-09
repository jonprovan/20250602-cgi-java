package com.skillstorm;

public class BooleanOperations {

	public static void main(String[] args) {
		
		/*
		 * BOOLEAN OPERATIONS
		 * 
		 * Operators include:
		 * ==
		 * <
		 * >
		 * <=
		 * >=
		 * 
		 * &&
		 * ||
		 * &
		 * |
		 * !
		 * 
		 * Also, we have some shorthand ways of assigning values using booleans
		 * Like the ternary operator!
		 */
		
		System.out.println(3 < 5);
		System.out.println(3 < 5 && 5 < 3);
		System.out.println(3 < 5 && 5 < 3 || 2 == 2);
		System.out.println(3 > 5 || 5 < 3 && 2 == 2 && 2 == 3);
		
		// just like the equation below, things on the left have to wait for things on the right to evaluate before continuing
		// shorter boolean statements execute basically left to right
		// but if the righthand side is complex, the left side must wait for evaluation
		
		int x = 1 + 2;
		
		// parentheses make your life a lot easier
		String name1 = "Joe";
		String name2 = "Jane";
		String genre = "Klezmer";
		
		if ((name1.equals("Joe") || name2.equals("Jill")) 
		 && (genre.equals("Neo Soul") || genre.equals("Klezmer")))
				System.out.println("Easier to parse!");
		
		// the not operator -- !
		boolean happy = false;
		
		// you can apply it directly to boolean values
		if (!happy) {
			System.out.println("Sad...");
		}
		
		// if you want to apply it to a boolean statement, you can put it before the statement wrapped in parentheses
		int y = 7;
		int z = 5;
		
		if ( !(y < z) )
			System.out.println("y is more than z in this case.");
		
		if ( 3 != 5 )
			System.out.println("Nope, not equal.");
		
		// the ternary operator
		// this operator allows us to ask a boolean question, then return a different value if it's true or false
		
		String studentName;
		int studentIdNumber = 6;
		
//		if (studentIdNumber == 5)
//			studentName = "Tiffiny";
//		else
//			studentName = "Anonymous";
		
//		System.out.println(studentName);
		
		/*
		 * SYNTAX
		 * 
		 * <variable to which we're assigning value> = <boolean question> ? <value to assign if true> : <value to assign if false>;
		 */
		studentName = (studentIdNumber == 5) ? "Tiffiny" : "Anonymous";
		
		System.out.println(studentName);
		
		int num = (!(10 * 3 == 40)) ? 0 : 1;
		
		System.out.println(num);
		
		boolean answer = (1 * 11 == 11 && 5 / 2 == 2) ? false : true;
		
		System.out.println(answer);
		
		String choice = (2 < 4) ? (5 < 3) ? "first" : "second" : "third";
		
		// the above boils down to this after we evaluate the internal, complete ternary statement
		// choice = (2 < 4) ? "second" : "third";
		
		System.out.println(choice);
		
		// dead code
		// if code cannot be reached because of hard-coded values, it'll be marked as "dead code" by the IDE
		// it will still compile, it just won't ever run!
		if (false) {
			System.out.println("Dead Code");
		}
		
		
		// logical operator shorthand
		// if you use bitwise & or bitwise |, BOTH sides of the question ALWAYS get evaluated
		int g = 3;
		int h = 4;
		if (g == 2 & h == 4)
			System.out.println("Both were true.");
		
		if (g == 2 && h == 1/0)
			System.out.println("Both were true again.");
		
		Book myBook = new Book("The Stars My Destination");
		myBook = null;
		
		// safeguarding against Exceptions using && or ||
		// for &&, if the left side returns false, the right side doesn't get processed -- we already know the && is false
		// for ||, if the left side returns true, the right side doesn't get processed -- we already know the || is false 
		if (myBook != null && myBook.title == "The Stars My Destination")
			System.out.println("Such a good book...");
		

	}

}

class Book {
	
	// instance property or instance variable
	// it has a distinct value for each instance of the class (each object made from this class)
	public String title;
	
	public Book(String title) {
		this.title = title;
	}
}
