
public class VariableScope {

	public static void main(String[] args) {
		
		/*
		 * VARIABLE SCOPE IN JAVA
		 * 
		 * Scope describes how far you have access to a variable
		 * Variables exist for a time, then stop existing
		 * We can control how long it exists
		 * 
		 * We have different types of variable in Java
		 * 
		 * local variable -- one that is created within a method
		 * block-scoped variable -- one that is created with a block
		 * 
		 * when we're dealing with Classes/Objects, we have:
		 * 
		 * instance properties -- variables belonging to a specific instance or object
		 * -- like myDog3.height or jeffsDodgeChallenger.topSpeed
		 * static properties -- variables belonging to the Class itself
		 * -- like Dog.numberOfDogs or Integer.MAX_VALUE or System.out
		 * 
		 */
		
		// this is a local variable
		// it is local to the main method, so technically it exists for the duration of our program
		String name = "Billy Madison";
		
		// this is a block-scoped variable
		// x only exists until the if block is complete, then it and its value vanish
		if (3 > 2) {
			int x = 3;
			// this change works, because name is still in scope
			name = "Happy Gilmore";
		}
		
		// can't do this
//		System.out.println(x);
		
		// but we DO have access in the block to variables that are "in scope", i.e. visible to the block, like name
		System.out.println(name);
		
		// true for loop variables as well
		// even though the i variable is getting created in the parentheses
		// this is somewhat like declaring a local variable as a parameter
		for (int i = 0; i < 3; i++) {
			System.out.println(i);
		}
		
		// can't do this; i no longer exists
//		System.out.println(i);
		
		// you can even just create a block on your own
		// then the variables get tossed when the block is complete
		{
			int z = 3;
		}

		// can't do this
//		System.out.println(z);
		
		// using Objects
		Dog dog1 = new Dog(100);
		Dog dog2 = new Dog(50);
		
		System.out.println(dog1.weight);
		System.out.println(dog2.weight);
		System.out.println(Dog.numberOfDogs);
		
		// this technically works, but is improper because this variable does not belong to this instance
		// ***** ALSO, THIS SYNTAX WILL BE CONSIDERED NON-COMPILING ON THE CERTIFICATION EXAM!! *****
		System.out.println(dog1.numberOfDogs);
		
	}
	
	public static void variableHolder() {
		// this is ALSO a local variable
		// it is local to the variableHolder method ONLY
		// and doesn't exist outside of it
		// the minute this method closes, out, z and its value go away
		int z = 11;
	}
	
	// we can also create a local variable by taking in a parameter
	// here, num exists for the duration of this method
	public static short parameterVariable(short num) {
		num = 45;
		return num;
	}

}

class Dog {
	
	// instance variable
	public int weight;
	
	// static variable
	public static int numberOfDogs = 0;
	
	public Dog(int weight) {
		this.weight = weight;
		numberOfDogs++;
	}
	
}





