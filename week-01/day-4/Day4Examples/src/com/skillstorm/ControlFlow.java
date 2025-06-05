package com.skillstorm;

public class ControlFlow {

	public static void main(String[] args) {
		
		// CONTROL FLOW IN JAVA
		
		/*
		 * without any control, statements execute top-to-bottom
		 * 
		 * however, we may want to execute things conditionally
		 * - skip a statement if something is true
		 * - choose between statements whether something is true/false
		 * - select between multiple statements based on the value of something
		 * - check if something is valid before continuing, etc.
		 * 
		 * MOST of these control flow concepts require a boolean value of some sort
		 * SOME require something else
		 * 
		 * CONDITIONAL STATEMENTS
		 * - if
		 * - else
		 * - else if
		 * - switch
		 * 
		 * OTHER THINGS WE'LL DISCUSS LATER
		 * - while
		 * - do
		 * - for
		 * - try/catch
		 * 
		 */
		
		// the if statement
		// if a condition is true, do something
		// otherwise, do nothing
		// this condition MUST resolve to a boolean
		
		/*
		 * SYNTAX
		 * 
		 * -- for one or more statements of code:
		 * 
		 * if (condition) {
		 * 		some code
		 * }
		 * 
		 * -- for one statement of code ONLY:
		 * 
		 * if (condition)
		 * 		some statement
		 */
		
		int x = 5;
		
		// the if statement
		if (x < 10) {
			System.out.println("x is less than 10.");
			System.out.println("Huzzah!");
		}
		
		// you can skip the braces, but only the next single line will be conditional on the if
		// this can be shorter but perhaps less readable in certain instances like this one
		if (x > 10)
			System.out.println("This is one line of code.");
			System.out.println("Happens regardless...");
		
			
		int y = 10;
		
		// conditions don't have to be simple
		if (y > 5 ? x > 4 : "abc".equals("zyx")) {
			System.out.println("What?");
		}
		
		if (x == 5 && y == 10 && "Albert".charAt(1) == 'l') {
			System.out.println("x is 5, y is 10, and Albert's second letter is l.");
		}
		
		// doesn't even have to be on a new line!
		if (x < 10) System.out.println("One line!");
		
		
		// the else statement
		// to use else, we need an if first
		// else is a catchall -- ANY other possibility than the condition being true will execute the else
		// same rules apply with the braces
		
		int z = 1;
		
		if (z == 12) {
			System.out.println("z was 1.");
		} else {
			System.out.println("z was NOT 1.");
		}
		
		if (z == 1)
			System.out.println("One-line version, and it was 1.");
		else
			System.out.println("One-line version, and it wasn't 1.");
		
		// to check more than one thing and have a different result for each possibility
		// we need to use else if
		// same rules apply with the braces
		// this requires an if first as well
		// you can have as many else ifs as you like
		
		String name = "Elizabeth";
		
		if (name.equals("Michael")) {
			
			System.out.println("Michael is in da house!");
			
		} else if (name.equals("Jeff")) {
			
			System.out.println("Jeff is in da house!");
			
		} else if (name.equals("Elizabeth")) {
			
			System.out.println("Elizabeth is in da house!");
			
		} else if (name.equals("Tiffiny")) {
			
			System.out.println("Tiffiny is in da house!");
			
		} else {
			System.out.println("It was some other random person.");
		}
		
		// you can have ONLY one else, and it has to be AT THE END
		// since it's a catchall, it snaps up ALL other possibilities for the variable
			
		// in the above example, the order doesn't matter
		// but it CAN, sometimes...
		
		// in the below example, if we check the name first, and the object is null, we throw an Exception
		// so, we should check for null FIRST, then check the name
		// because the first check would eliminate the possibility of an Exception on the second check
		
		Person person = null;
		
//		if (person.name.equals("Clark")) {
//			System.out.println("Person's name is Clark.");
//		} else if (person == null) {
//			System.out.println("Person is null.");
//		}
		
		
		// the switch statement
		// when you have a variable, and you want to check its value
		// and its value is NON-BOOLEAN
		// and you want to do something different based on each value
		// a switch statement can be cleaner and very useful
		
		char grade = 'B';
		// boolean passed = true;
		
		// can't switch on a boolean, so we'll use grade
		switch (grade) {
			
			// each of the cases is like a check
			// if grade equals 'A', start here
			case 'A':
				System.out.println("Your grade is: " + grade);
				System.out.println("You're top o' the class!");
				break;
				
			// else if grade equals 'B', start here
			case 'B':
				System.out.println("Your grade is: " + grade);
				System.out.println("Solid showing, mate.");
				break;
				
			case 'C':
				System.out.println("Your grade is: " + grade);
				System.out.println("Super average, bro.");
				break;
				
			case 'D':
				System.out.println("Your grade is: " + grade);
				System.out.println("You have a LOT of work to do...");
				break;
				
			case 'F':
				System.out.println("Your grade is: " + grade);
				System.out.println("Banished! 10 years on the wall. Winter is coming...");
				break;
				
			// default is like else and will catch ALL other possibilities
			// it can go ANYWHERE in the switch block
			// but it's traditionally found at the end
			default:
				System.out.println("What kind of grade is that?");
				break;

		}
		
		int countdownStart = 10;
		
		switch (countdownStart) {
			
			default:
				if (countdownStart > 5) {
					int current = countdownStart;
					while (current > 5) {
						System.out.println(current-- + "...");
					}
				} else {
					System.out.println("Invalid number!");
					break;
				}
		
			case 5:
				System.out.println("5...");
			case 4:
				System.out.println("4...");
			case 3:
				System.out.println("3...");
			case 2:
				System.out.println("2...");
			case 1:
				System.out.println("1...\nLIFTOOOOOOOOOOOFF!!");
		}
		
		// rewriting our earlier name if/else if/else statements as a switch
		
		String name2 = "Elizabeth";
		
		switch (name2) {
			case "Michael":
				System.out.println(name2 + " is in da house!"); break;
			case "Jeff":
				System.out.println(name2 + " is in da house!"); break;
			case "Elizabeth":
				System.out.println(name2 + " is in da house!"); break;
			case "Tiffiny":
				System.out.println(name2 + " is in da house!"); break;
			default:
				System.out.println("It was some other random person.");
		}
		
		// refactored with a method for common functionality
		switch (name2) {
			case "Michael":
				daHouse(name2); break;
			case "Jeff":
				daHouse(name2); break;
			case "Elizabeth":
				daHouse(name2); break;
			case "Tiffiny":
				daHouse(name2); break;
			default:
				System.out.println("It was some other random person.");
		}
		
		// getting even sneakier...
		switch (name2) {
			case "Michael":
			case "Jeff":
			case "Elizabeth":
			case "Tiffiny":
				daHouse(name2); break;
			default:
				System.out.println("It was some other random person.");
		}
		
	}
	
	public static void daHouse(String name) {
		System.out.println(name + " is in da house!");
	}

}

class Person {
	String name;
	
	public Person(String name) {
		this.name = name;
	}
}
