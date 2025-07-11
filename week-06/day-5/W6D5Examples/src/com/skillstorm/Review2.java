package com.skillstorm;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Review2 {

	public static void main(String[] args) {
		
		try {
			
		} catch (Exception e) {
			
		}
		
		try {
			
		} finally {
			
		}
		
		try {
			
		} catch (Exception e) {
			
		} finally {
			
		}
		
		try {
			throw new IOException();
		} catch (RuntimeException e) {
			
		} catch (IOException e) {
			
		}
		
		
		// this doesn't work, because the Exception catch gets ALL of them, INCLUDING RuntimeExceptions
//		try {
//			
//		} catch (Exception e) {
//			
//		} catch (RuntimeException e) {
//			
//		}
		
		// but this works
		try {
			
		} catch (RuntimeException e) {
			
		} catch (Exception e) {
			
		}
		
//		String s = null;
//		System.out.println(s.toString());
		
		int[] nums = { 1, 2, 3, 4, 5 };
		nums = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
		System.out.println(nums[10]);
		
		// you are not forced by the compiler to catch RuntimeExceptions, but you can and should, if they're possible
		// when handled, Exceptions DO NOT stop the program, and it continues to whatever's after
		
		try {
			String s = null;
			System.out.println(s.toString());
		} catch (NullPointerException e) {
			e.printStackTrace();
			System.out.println("The program continues from here...");
		}
		
		System.out.println("...to this message, which is after the try/catch.");
		
		// with checked Exceptions (anything that's not in the RuntimeException tree, you are FORCED by the compiler to handle them
		
		File f = new File("abc.txt");
		// this action MAY throw a checked Exception, so we MUST handle it somehow
//		FileReader fr = new FileReader(f);
		
		try {
			FileReader fr = new FileReader(f);
		} catch (FileNotFoundException e) {
			
		}
		
		// note that, because the Exception thrown in this method is a RuntimeException
		// even if we declare the method throws that Exception
		// we DO NOT have to handle it
		// it throws the ArithmeticException at runtime
//		a();
		
//		throw new RuntimeException("Uh-oh...");
		
		// some methods may possibly throw multiple checked Exception types
		// you have to handle them ALL somehow
		
		try {
			b();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			b();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		try {
			b();
		} catch (FileNotFoundException | CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Caught again!");
		

		
	}
	
	public static void a() throws ArithmeticException {
		int x = 1/0;
	}
	
	// the action taken in this method MIGHT throw an Exception
	// we can handle it within the method
	// or, we can state to the called that it MIGHT throw an Exception
	// then, since it's a checked Exception, the caller MUST handle it there!
	// if a method might throw multiple Exception types, you can indicate that with "throws A, B, C, etc."
	public static void b() throws FileNotFoundException, CloneNotSupportedException {
		if (Math.random() > 0.5) {
			File f = new File("abc.txt");
			FileReader fr = new FileReader(f);
		}
		throw new CloneNotSupportedException();
	}
	
	
	
	

}
