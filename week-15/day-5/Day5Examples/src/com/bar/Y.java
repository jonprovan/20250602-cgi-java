package com.bar;

//1  <== INSERT STATEMENT(s) HERE
// we need BOTH of these to execute the code as written!!

import com.foo.*;				// could also use import com.foo.X
import static com.foo.X.*;		// could also use import static com.foo.X.LOGICID

public class Y {
	public static void main(String[] args) { 
		X x = new X();			// this won't work without the first one
		x.apply(LOGICID);		// this won't work without the second one
	}
}

// if the last line were changed to x.apply(X.LOGICID), you would only need the first one!
// by importing X, you have access to its static properties and methods
// so you COULD call the static property in the regular way, using the class name