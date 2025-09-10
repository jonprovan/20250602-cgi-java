// Consider the following TestClass.java file in the current directory:  
package a.a.a;

public class TestClass {
	public static void main(String[] args) {
		System.out.println("Good!!!");
	}
}

// Which of the following command lines should be used for compiling 
// if the generated class file is to be executed using the following command line:  java -classpath . a.a.a.TestClass

// java is for running, not compiling, so we can eliminate those two options
// the -d flag creates the package directory structure at the location indicated afterward
// so -d . creates a/a/a/TestClass.class,
// whereas -d a.a.a creates a.a.a/a/a/a/TestClass.class

/*
 * java TestClass.java				X
 * javac -d a.a.a TestClass.java
 * javac -d . TestClass.java 		Y -- this will place the package structure at this spot (that's what the . means), which matches the call above
 * javac -d ../a TestClass.java
 * java -d TestClass.java			X
 * 
 */
