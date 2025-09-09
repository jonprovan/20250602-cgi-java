package com.skillstorm;

// Given:  
public class TestClass5 {     
	static int a;     // this is a static property that belongs to the class itself -- it DOES NOT get reset when new instances are created!
	int b;  		  // this is an instance property whose value starts at 0 for ANY new object
	
	public void incr() {        
		int c = a++;        
		b++;        
		c++;        
		System.out.println(a+" "+b+" "+c);     
	}    
	
	public static void main(String args[]) {       
		TestClass5 test = new TestClass5();  // this object's b starts at zero...     
		test.incr();       
		a++;       
		test = new TestClass5();   // here, we're creating a NEW object for test to point to, so its b gets reset to 0 (a keeps its current value)
		test.incr();    
	} 
}

// What will be the output? 