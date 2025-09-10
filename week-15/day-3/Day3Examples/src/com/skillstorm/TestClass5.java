package com.skillstorm;

// What will be the output of the following program:  

public class TestClass5 {
	
	public static void main(String args[]) {
		try {
			m1();
		} catch (IndexOutOfBoundsException e) {
			System.out.println("1");
			throw new NullPointerException();
			
			// to catch this, we'd have to do:
//			try {
//				throw new NullPointerException();
//			} catch (NullPointerException e2) {
//				e2.printStackTrace();
//			}
			
		} catch (NullPointerException e) {	// this catch will ONLY catch things thrown in the try, NOT a previous catch!!
			System.out.println("2");
			return;
		} catch (Exception e) {				// same here
			System.out.println("3");
		} finally {
			System.out.println("4");		// finally blocks ALWAYS execute, whether the try works, the Exception is caught, or the program ends
		}
		System.out.println("END");
	}

	// IndexOutOfBoundsException is a subclass of RuntimeException. 
	static void m1() {
		System.out.println("m1 Starts");
		throw new IndexOutOfBoundsException("Big Bang");
	}
}