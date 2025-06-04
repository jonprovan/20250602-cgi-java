// package declaration comes BEFORE imports
package com.skillstorm;

// imports come BEFORE class declaration
// when you type an import into your code, press Ctrl-Space to show the list of possible imports
// then press Enter on the one you want to import it
import java.util.Random;

public class MathClass {

	public static void main(String[] args) {
		
		/*
		 * Java has a Math class we can access for various mathematical methods and operations
		 * These methods are static methods, meaning we don't need a Math object
		 * We can just call the methods from the Math class directly
		 * 
		 * There are dozens of methods in this class, but a few are particularly useful
		 * 
		 * .pow() -- for using exponents
		 * .sqrt() -- for getting the square root
		 * .floor() -- for getting the next smallest integer below a double value -- rounding down!
		 * .ceil() -- rounding up
		 * .random() -- generating a random number between 0 and 1
		 */
		
		// .pow()
		// the first parameter is the number you want to take to the second parameter power, so this is 2 to the 8th power
		// NOTE -- static methods and properties show up in italics!
		double exponentResult = Math.pow(2, 8);
		
		// NOTE -- final properties and methods show up in bold
		System.out.println(exponentResult);
		
		// negative powers work, too
		exponentResult = Math.pow(10, -3);
		
		System.out.println(exponentResult);
		
		// PEMDAS holds up here -- the pow() operation has to resolve before multiplying by 9
		double result = 3 + 9 * Math.pow(2, 2);
		
		System.out.println(result);
		
		
		// sqrt()
		// returns the square root of the single parameter
		double root = Math.sqrt(81);
		
		System.out.println(root);
		
		// in math-nerd terms, this SHOULD be 9i...
		root = Math.sqrt(-81);
		
		// ...but Java doesn't understand imaginary numbers...alas!
		System.out.println(root);
		
		
		// .floor() and .ceil() work similarly, rounding up or down to the next integer, respectively
		double floor = Math.floor(105.35);
		
		System.out.println(floor);
		
		double ceiling = Math.ceil(105.35);
		
		System.out.println(ceiling);
		
		// can use these to round to certain decimal point limits
		double price = 599.34567896578;
		
//		price *= 100;
//		price = Math.floor(price);
//		price /= 100;
		
		price = Math.floor(price * 100) / 100;
		
		System.out.println(price);
		
		
		// .random()
		double random = Math.random();
		
		System.out.println(random);
		
		int randomOneTen = (int)Math.ceil(Math.random() * 10);
		
		// same result, but Elizabeth's ceiling method is better and more fun!
		// randomOneTen = (int)(Math.random() * 10 + 1);
		
		System.out.println(randomOneTen);
		
		// using the Random class, there's a shorthand
		// note that this involves instantiating a new Object from the Random class, then calling one of its methods
		int randomInt = new Random().nextInt(10) + 1;
		System.out.println(randomInt);
	}

}
