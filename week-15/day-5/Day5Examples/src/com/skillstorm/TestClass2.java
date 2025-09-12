package com.skillstorm;

public class TestClass2 {

	public static void main(String[] args) {

		// What will the following code print?
		boolean flag = true;
		if (flag = false) {				// this line is the trick of this question
										// it's an ASSIGNMENT, not a value check!! (= instead of ==)
										// the assignment operator returns the value assigned, so here, we get false AND flag becomes false overall
										// this WOULD NOT work if it were not a boolean variable, since conditions REQUIRE booleans!
			System.out.println("1");
		} else if (flag) {
			System.out.println("2");
		} else if (!flag) {
			System.out.println("3");
		} else
			System.out.println("4");

	}

}
