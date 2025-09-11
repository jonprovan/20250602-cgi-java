package com.skillstorm;

public class TestClass4 {

	public static void main(String[] args) {

		// What will the following code print?
		int i = 0;							// since these variables are created at the main method scope, they're available wherever we want to use them
		int j = 1;
		if ((i++ == 0) && (j++ == 2)) {		// BOTH of these check for equality BEFORE incrementing, since they're postfix increments
											// as such, the first evaluates to TRUE, and the second evaluates to FALSE, which makes the whole thing false
											// with && and ||, there's the possibility of a shortcut:
											// with &&, if the left side is FALSE, we don't even check the right side (would mean no j increment here)
											// with ||, if the left side is TRUE, we don't check the right
											// in both cases, if we know the answer to the whole condition based on the left side, no need to check it
			i = 12;
		}
		System.out.println(i + " " + j);

	}

}
