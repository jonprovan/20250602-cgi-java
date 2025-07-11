package com.skillstorm;

public class Review1 {

	public static void main(String[] args) {
		
		// nested for loops
		// prefix/postfix in the for loop syntax
		
		int x = 0;
		
		// on their own lines, these are identical
		x++;
		
		System.out.println(x);
		
		++x;
		
		System.out.println(x);
		
		for (int i=0; i < 3; i++) {
			System.out.println(i);
		}
		
		for (int i=0; i < 3; ++i) {
			System.out.println(i);
		}
		
		// i is out of scope now
//		System.out.println(i);
		System.out.println();
		
		// ALL THREE syntax slots are optional, with different consequences
		
//		int j = 10;
//		for ( ; j < 13; ) {
//			System.out.println(j++);
//		}
		
		System.out.println();
		
		// since you can do this on one line, you can do it in a loop
//		int a = 3, b = 4, c = 5;
		
		// this is valid
//		for (int a = 3, b = 4, c = 5; a < 5 && b < 5 && c < 5; a++, b++, c++) {
//			
//		}
		
		int c = 0;
		
		A: for(int i = 0; i < 2; i++) {
			B: for(int j = 0; j < 2; j++) {
				C: for(int k = 0; k < 3; k++) {
					c++;
					if(k > j)
						break;
				}
			}
		}
		
		System.out.println(c);
		
		// no need for braces if the "body" is only one line
		for (int i = 0; i < 3; i++)
			System.out.println(i);
		
		// empty curly braces are okay
		for (int i = 0; i < 3; i++) {}
		
		for (int i = 0; i < 3; i++)
			
		
			// even if you put it way later, the for is still expecting SOMETHING
			
			
			
			System.out.println(i);
		
		// switch expects a block, even if it's empty
		// you can't do a one-liner
		switch (x) {}
		
		
}

}
