package com.skillstorm;

// In the following code what will be the output if 0 (integer value zero) is passed to loopTest()?   

public class TestClass1 {    
	
	public void loopTest(int x) {       
		loop: for (int i = 1; i < 5; i++) {          
				for (int j = 1; j < 5; j++) {             
					System.out.println(i);             
					if (x == 0) {  
						continue loop;  // this is important -- x is always 0, so we never make it to the j println, but we do go to the next loop iter.
					}             
					System.out.println(j);          
				}      
		}    
	}
	
	public static void main(String[] args) {
		TestClass1 tc = new TestClass1();
		
		tc.loopTest(0);
	}
	
	
}  