package com.skillstorm;

public class TestClass8 {
	
	public static void main(String[] args) {
		
		// What will the following code snippet print?
		int count = 0, sum = 0;
		do {
			if (count % 3 == 0) // this skips the sum addition when count is 0, 3, 6, 9, etc.
				continue;
			sum += count;
		} while(count++ < 11);  // this is tricky! the check is made BEFORE the incrementation, so the loop runs once more with count at 11 before stop
		
		System.out.println(sum);

		// What will be the output of the following code snippet?
		int a = 1;
		int[] ia = new int[10]; 	// default values for this array are 0 in every slot
		int b = ia[a]; 				// so, this assigns 0 to b
		int c = b + a;				// this assigns 1 to c
		System.out.println(b = c);	// then, this has an assignment operator, NOT a == check!! so b gets assigned 1,
									// and the assignment operator returns the value assigned, so we print 1
	}
}