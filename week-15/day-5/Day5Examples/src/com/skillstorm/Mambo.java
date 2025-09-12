package com.skillstorm;

// What will the following code print when run?  

public class Mambo {
	static int m = 10, n = 20;

	public static void main(String args[]) {
		int m = 0, n = 10;						// it's OKAY to have the same variable names at local and static/instance scopes!
												// however, methods with duplicates like this will ALWAYS default to the LOCAL scope
												// if we want to use the static scope, we need to say Mambo.m or Mambo.n
		Mambo mb = new Mambo();					// if they were instance properties and we wanted to use the instance properties of this mb object
		while (m < 3) {							// we'd need to say mb.m and mb.n
			m++;								// in non-static methods, including constructors, we'd use this.m and this.n like we've done before!
			n--;
		}
		System.out.println(m + ", " + n);
	}
}