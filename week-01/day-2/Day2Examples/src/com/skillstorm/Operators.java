package com.skillstorm;

public class Operators {

	public static void main(String[] args) {
		
		// OPERATORS IN JAVA
		
		/*
		 * MATHEMATICAL
		 * 
		 * + -- addition, like 3 + 4
		 * - -- subtraction
		 * / -- division
		 * * -- multiplication
		 * % -- modulus or modulo, returns the remainder of a division operation, so 5 % 4 returns 1
		 * = -- assignment operator, not strictly mathematical, but assigns a value to a variable, like int x = 77
		 * 
		 * To increment, I could do int i = 10; i = i + 1; i = i * 123;
		 * 
		 * ++  adds one to the value
		 * --  subtracts one from the value
		 * (for the above, it matters whether you do i++ or ++i ... will discuss later)
		 * 
		 * += -- adds the following value to the original value, like int z = 10; z += 10, now the value of z == 20
		 * -=
		 * /=
		 * *=
		 * %=		 
		 * 
		 * Exponents don't have a default operator, but you'd do something like Math.pow(3, 4)
		 * 
		 * 
		 * COMPARISON
		 * these return a boolean value
		 * 
		 * == -- are the two values equal? like if (i == 5), etc.
		 * < -- less than
		 * > -- greater than
		 * <= -- less than or equal to
		 * >= -- greater than or equal to
		 * ! -- not
		 * != -- not equal to
		 * 
		 * to use some of these in combination, you'd do something like if (!(x <= 4))
		 * 
		 * 
		 * 
		 * LOGICAL/RELATIONAL
		 * these require that the things on either side are already booleans!
		 * for example, this doesn't work -- 3 && 4
		 * but this does -- x == 3 && y == 4
		 * 
		 * these two shortcut if they return an answer after the first statement
		 * && -- and
		 * || -- or
		 * these two check both sides regardless
		 * & -- bitwise and
		 * | -- bitwise or
		 * ^ -- XOR or exclusive or, meaning ONLY one or the other is true but NOT BOTH!
		 * 
		 * if you want to do NAND (not and), NOR (not or), etc., you have to do them longhand
		 * if (!(x == 5 && z == 11))
		 * 
		 */
		
		// Math operator examples
		int myInt = 100;
		System.out.println(myInt);
		
		myInt = myInt + 100;
		System.out.println(myInt);
		
		myInt += 100;
		System.out.println(myInt);
		
		myInt = 100;
		
		myInt %= 75;
		System.out.println(myInt);
		
		// overflow/underflow
		byte myByte = 127;
		System.out.println(myByte);
		
		myByte += 1;
		System.out.println(myByte);
		
		myByte -= 1;
		System.out.println(myByte);
		
		/*
		 * Computers think of values in binary
		 * a byte is 8 bits, and a bit can be 0 or 1 ONLY!
		 * so, a minimum-value byte is seen by a computer as 00000000
		 * and a max-value byte is 11111111
		 * 00000000, 00000001, 00000010, 00000011, 00000100
		 * after max value, we'd be at 100000000 (a 1 and 8 zeroes)
		 */
		
		// ORDER OF OPERATIONS
		// PEMDAS applies -- Parentheses, Exponents, Mult, Div, Add, Sub
		// * and / are at equal priority, also + and -
		// those go left to right
		int order = 1 + 6 / 2 * 10 - 5;
		System.out.println(order);
		
		order = 1 + 3 * 10 - 5;
		order = 1 + 30 - 5;
		
		// you can use parentheses to highlight the order or make it more readable
		order = 1 + ((6 / 2) * 10) - 5;
		
		// you can also use it to change the order if you like
		order = 1 + 6 / 2 * (10 - 5);
		System.out.println(order);
		
		// the assignment operator (=) takes least precedence!
		// we need to evaluate ALL the operations on the right before assigning the value to the thing on the left
		
		// you can operate on variable values, too!
		int x = 65;
		int y = 75;
		int z = x + y;
		
		System.out.println(z);
		
		// watch out for your variable types when dividing!!
		// this works fine, because 4 / 2 is an integer
		int a = 4 / 2;
		System.out.println(a);
		
		// this doesn't, because we're dividing integers, so we get an integer answer -- 2.5 gets truncated to 2
		int b = 5 / 2;
		System.out.println(b);
		
		// even if we change the variable type, the right-hand side still evaluates to an integer, because we're dividing integers
		double c = 5 / 2;
		System.out.println(c);
		
		// we can add decimals to one or both numbers on the right to have them divide as doubles
		double d = 5.0 / 2.0;
		System.out.println(d);
		
		// or we can cast one or both on the right to doubles
		double e = (double)5 / 2;
		System.out.println(e);
		
		// this will throw an Exception, specifically an ArithmeticException, so we can't do it
		// int uhuh = 1/0;
		
		// doubles divided by 0 return Infinity, which is still kind of a problem, but no Exception
		double nope = (double)1/0;
		System.out.println(nope);
		
		// INCREMENTING/DECREMENTING
		int value = 1;
		System.out.println(value);
		
		value += 1;
		System.out.println(value);
		
		// this does the same thing as the previous incrementation
		value++;
		System.out.println(value);
		
		// so does this
		++value;
		System.out.println(value);
		
		// however, if we're using the value in some way, not simply incrementing it, the placement of the ++ matters
		// in this case -- a prefix increment -- we increment the value FIRST, then return the new value
		System.out.println(++value);
		
		// here -- a postfix increment -- we return the CURRENT value, THEN increment it
		System.out.println(value++);
		
		// we can see here that the value was in fact incremented in the last statement
		System.out.println(value);
		
		int newValue = 10;
		
		// here, the equation takes the value first, then increments later
		System.out.println(20 + newValue++);
		
		System.out.println(newValue);
		
		// here, the called method takes the value first, then increments later
		System.out.println(returnValue(newValue++));
		
		int index = 0;
		
		// pulling the current value first can be useful in many situations
		while (index < 5) {
			System.out.println("Loop Index = " + index++);
		}
		
		// works the same for decrementing
		int otherIndex = 0;
		
		System.out.println(--otherIndex);

		System.out.println(otherIndex--);
		
		System.out.println(otherIndex);
		
		

	}
	
	public static int returnValue(int input) {
		return input;
	}

}
