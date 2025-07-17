package com.skillstorm;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTests {
	
	/*
	 * TESTING AND TEST-DRIVEN DEVELOPMENT
	 * 
	 * There are many types of software testing -- unit, integration, deployment, etc.
	 * All are designed to make sure your software functions as intended before it goes live
	 * 
	 * In test-driven development, the tests are written FIRST, then the code is developed to satisfy the tests
	 * This creates a set of requirements for your software that it MUST do
	 * 
	 * We will NOT be using a test-driven development approach as a requirement
	 * But it can be useful as a tool to set up requirements for your project
	 * 
	 * Each test takes a certain action, then asserts something about the result
	 * - for instance, that the output of a method is a certain type or value
	 * - that a created object has certain properties
	 * - that a method with a certain input will throw an Exception
	 * 
	 * There are a series of different annotations we'll use in this Test Case
	 * They indicate where in the process certain methods will execute
	 * 
	 * @BeforeAll -- this method will run ONCE TOTAL before ANY tests occur; it must be static!
	 * -- the next three MUST be non-static
	 * @BeforeEach -- this method will run once before each test in your class
	 * @Test -- a single unit test
	 * @AfterEach -- this method will run once after each test in your class
	 * @AfterAll -- this method will run ONCE TOTAL after ALL tests occur; it must be static!
	 * 
	 * BeforeAll/AfterAll are useful for setting up and tearing down global/constant resources to be used in all tests
	 * BeforeEach/AfterEach are useful for setting up/resetting resources to a "blank slate" state before each test
	 * 
	 * NOTE -- test order is NOT guaranteed!
	 * 
	 * ASSERTIONS
	 * there are many assertions to choose from
	 * assertEquals, assertNotEquals, assertTrue, assertFalse are common, but use whichever you like!
	 * you can also manually fail a test using fail() if you just want to run your own logic to determine what's a fail
	 * you can also assertThrows for a specific type of Exception, but there's a cleaner way to do this
	 * 
	 * Unit tests should be pretty narrow and specific
	 * If you're asserting many different things in one test, it can be difficult to determine what's working and what isn't
	 */
	
	// a static Calculator to use in all our tests
	// it gets initialized in our BeforeAll method
	static Calculator calc;

	@BeforeAll
	static void setup() {
		System.out.println("*** BeforeAll Setup ***");
		calc = new Calculator();
	}
	
	@BeforeEach
	void beforeEach() {
		System.out.println("*** BeforeEach ***");
	}
	
	@Test
	void noArgsConstructor() {
		Calculator temp = new Calculator();
		assertTrue(temp instanceof Calculator);
		assertEquals("Default", temp.type);
	}
	
	@Test
	void oneArgConstructor() {
		Calculator temp = new Calculator("Graphing");
		assertTrue(temp instanceof Calculator);
		assertEquals("Graphing", temp.type);
	}
	
	
	
	// each test will assert something
	// in this case, we're asserting that the sum of 5 and 7 as added by our Calculator's add method will equal 12
	// if the assertion is correct, the test finishes and is considered "passed"
	// if the assertion is incorrect, the test throws an AssertionFailedError and is considered "failed"
	// this will NOT stop your program; all tests will run whether they pass or fail
	@Test
	void addTwoIntegers() {
		System.out.println("*** Add Two Integers ***");
		long sum = calc.add(5, 7);
		assertEquals(12, sum);
		System.out.println("PASSED!");
	}
	
	@Test 
	void addAndOverflow() {
		System.out.println("*** Add And Overflow ***");
		long sum = calc.add(Integer.MAX_VALUE, 1);
		assertTrue(sum > Integer.MAX_VALUE);
	}
	
	@Test
	void basicSubtraction( ) {
		System.out.println("*** Basic Subtraction ***");
		long difference = calc.subtract(3, 2);
		assertEquals(1, difference);
	}
	
	@Test
	void subtractAndUnderflow() {
		System.out.println("*** Subtract and Underflow ***");
		long difference = calc.subtract(Integer.MIN_VALUE, Integer.MAX_VALUE);
		assertTrue(difference < Integer.MIN_VALUE);
	}
	
	@Test
	void basicMultiplication( ) {
		System.out.println("*** Basic Multiplication ***");
		long product = calc.multiply(11, 11);
		assertEquals(121, product);
	}
	
	@Test
	void multiplyAndOverflow() {
		System.out.println("*** Multiply and Overflow ***");
		long product = calc.multiply(Integer.MAX_VALUE, Integer.MAX_VALUE);
		assertTrue(product == 4611686014132420609L);
	}
	
	// using assertThrows to assume that a certain action will throw a certain type of exception
	// the first argument is the specific class type of the exception you think will be thrown
	// the second argument is a lambda function doing whatever it is you think will throw the exception
	@Test
	void divideByZero() {
		System.out.println("*** Divide By Zero ***");
		assertThrows(IllegalArgumentException.class, () -> {
			calc.divide(1, 0);
		});
	}
	
	// for some math results, you may only care to a certain degree of accuracy
	// you can use a third parameter to indicate the margin of allowable error
	// this is called a "delta"
	// in this example, quotient could be 0.005 larger or smaller than 1.33 and still pass
	@Test
	void divideIntegers() {
		System.out.println("*** Divide Integers ***");
		double quotient = calc.divide(4, 3);
		assertEquals(1.3333, quotient, 0.00004);
	}
	
	@Test
	void randomTest() {
		double result = calc.mathClass(5, 5, "Random");
		Set<Double> possibilities = new HashSet<>(Set.of(0.0, 1.0, 2.0, 3.0, 4.0));
		
		// we CAN'T use assertEquals in this case (ignoring the seed piece)
		// since result could be any of many possibilities,
		// we need to construct a boolean statement that accounts for all possibilities
		// in this case, result could be any options listed in the set above
		assertTrue(possibilities.contains(result));
	}
	
	@Test
	void powerTest() {
		double result = calc.mathClass(2, 8, "Power");
		
		// when you DO have a specific, singular value you expect
		// you can use assertEquals to test for that value specifically
		assertEquals(256.0, result, 0.0000000001);
	}
	
	@Test
	void defaultTest() {
		double result = calc.mathClass(6, 7, null);
		assertEquals(0.0, result);
		result = calc.mathClass(6, 7, "");
		assertEquals(0.0, result);
		result = calc.mathClass(6, 7, "Nonsense");
		assertEquals(0.0, result);
	}
	
	@AfterEach
	void afterEach() {
		System.out.println("*** AfterEach ***");
	}
	
	@AfterAll
	static void teardown() {
		System.out.println("*** AfterAll Teardown ***");
		calc = null;
	}

}






