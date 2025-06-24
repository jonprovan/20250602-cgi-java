package com.skillstorm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionsInJava {

	public static void main(String[] args) {
		
		/*
		 * EXCEPTIONS IN JAVA
		 */
		
		// this will throw an ArithmeticException, which IS-A RuntimeException
		// this is UNCHECKED, and the compiler will not notify you about it!
//		int x = 1/0;
		
		// this will throw an ArrayIndexOutOfBoundsException, which also IS-AN unchecked RuntimeException
//		int[] nums = { 1, 2, 3 };
//		int y = nums[5];
		
		// you must anticipate and address these sorts of issues in advance!
		
		
		// however, this operation MIGHT throw a FileNotFoundException, which IS-AN IOException and is CHECKED!
		// the compiler KNOWS about this and won't let you proceed until you've handled it
//		File f = new File("text.txt");
//		FileReader fr = new FileReader(f);
		
		// the checked vs. unchecked behavior happens whether you manually throw the exception or it happens on its own
//		uncheckedChuck();
//		checkedChuck();
		
		
		// handling Exceptions right where they occur
		
		// most often, this is done in a try/catch
		// the code in the try block is what we want to do, even though it MIGHT throw an Exception
		// the parentheses of the catch state what type of Exception we want to catch
		// you must give it a type and a variable name (e.g. IOException e)
		// then the code in the catch block will ONLY execute if the Exception gets thrown in the try
		// wherever the Exception occurs in the try block, the block stops there
		// any code past the Exception in the try block WILL NOT execute
		
		// you MUST catch the type of Exception that will be thrown
		// BUT you CAN generalize, because, for example, ArithmeticExceptions ARE RuntimeExceptions AND Exceptions AND Throwables, etc.
		
		// if the Exceptions you're trying to catch have an IS-A relationship with each other, the ORDER MATTERS!
		// you must catch from most to least specific
		// otherwise, your least specific one will catch all the others!
		// if they're unrelated, like, for example, IOException and RuntimeException, the order DOES NOT MATTER!
		
		try {
			if (Math.random() > 0.5) {
				int z = 1/0;
			}
			else {
				int[] nums = { 1, 2, 3 };
				System.out.println(nums[5]);
			}
			
			System.out.println("Past the Exception in the try block");
			
		// we must catch this more specific one FIRST
		} catch (ArithmeticException e) {
			System.out.println("ArithmeticException caught!");
			e.printStackTrace();
			
		// then catch the more general one AFTER
		} catch (RuntimeException e) {
			System.out.println("ArrayIndexOutOfBoundsException caught!");
			e.printStackTrace();
		}
		
		System.out.println("Past the try/catch.");
		
		// you can also catch multiple Exception types in one catch
		// this is useful for common catch functionality that may not be possible by using a general type
		try {
			File f = new File("text.txt");
			FileReader fr = new FileReader(f);
		} catch (ArithmeticException | IOException e) {
			
		} catch (RuntimeException e) {
			
		}
		
		
		// finally
		// try/catch can ALSO have a finally block after it
		// this is strictly optional
		// the code in the finally block ALWAYS executes
		// if the try succeeds, the finally executes
		// if the try fails and you catch the Exception, the finally executes
		// if the try fails and you DON'T catch the Exception, and the program stops...the finally executes!
		
		// finally blocks are useful for any finishing action that's related to the logic in the try/catch
		// often, you'll see them used to close out resources created for the try/catch that are no longer useful
		try {
			if (Math.random() > 0.5) {
				throw new Exception("Number was big, y'all.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("Finally block is executing!");
		}
		
		// an example of closing resources in a finally block
		// a BufferedReader opens a data stream that must be closed after use to prevent memory leaks
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new FileReader(new File("test.txt")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			// closing it might throw a different type of Exception, so we have a nested try/catch here
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		// there's a shorthand for this as well, called a try-with-resources block
		try (BufferedReader br2 = new BufferedReader(new FileReader(new File("test.txt")))) {
			System.out.println("BufferedReader Created and auto-closed at the end of the try/catch");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		// what's optional?
		try {
			
		} catch (Exception e) {
			
		}
		
		try {
			
		} catch (Exception e) {
			
		} finally {
			
		}
		
		// you CAN have try and finally with NO catch
		try {
			
		} finally {
			
		}
		
		// you MUST have a try to use catch or finally
		// so this doesn't work
//		catch (Exception e) {
//			
//		} finally {
//			
//		}
		
		
		// if you don't want to handle Exceptions right where they're thrown
		// you can pass them up to the method that calls them
		// you can do this as many times as you like
		// all the way up to main, if you want
		// but you MUST handle them SOMEWHERE
		try {
			methodA();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		handleExceptions();
		
		
		// using our custom Exception
		try {
			String[] students = { "Elizabeth", "Jeff", "Mike", "Tiffiny", "Zoltar" };
			if (students.length > 4)
				throw new TooManyStudentsException("There can be only four.");
		} catch (TooManyStudentsException e) {
			e.printStackTrace();
		}
		
		
		
		System.out.println("Made it to the end!");

	}
	
	// notice how the compiler doesn't even care if we throw it ourselves (for unchecked RuntimeExceptions)
	public static void uncheckedChuck() {
		throw new RuntimeException("Yikes!");
	}
	
	// but it does here
	public static void checkedChuck() {
//		throw new IOException("Yikes twice!");
	}
	
	public static void methodA() throws Exception {
		// we CAN handle it here...
//		try {
//			throw new Exception("A manually thrown Exception from methodA");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		// OR, we can pass the buck!
		throw new Exception("A manually thrown Exception from methodA");
	}
	
	public static void methodB() throws Exception {
		throw new Exception("A manually thrown Exception from methodB");
	}
	
	public static void handleExceptions() {
		try {
			methodA();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			methodB();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

// you can create your own Exception types by extending Exception
// this can be useful for specific types of program issues you may wish to call out
class TooManyStudentsException extends Exception {
	public TooManyStudentsException(String message) {
		super(message);
	}
}
