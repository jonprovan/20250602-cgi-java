import java.util.Arrays;
import java.util.Objects;

import static java.lang.System.*;
import static java.lang.Integer.*;

public class EnthuwareReview {
	
	public int value;

	public static void main(String[] args) {
		
		try {
//			infinite();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} finally {
			System.out.println("********* FINALLY! *********");
		}
		
		int[] nums = { 1, 2, 3, 4, 5 };
		
		
		// loop labels and variables CANNOT use lowercase keywords like new or for as their names
		// you CAN use class names, like we do below
		// but you then have to specify the full class path if you want to use the original class, like we do with String a few lines down
		String: for (int num : nums) {
			System.out.println(num);
		}
		
		int ArrayList = 5;
		java.lang.String.valueOf(34.56);
		
		out.println("Stuff");
		
		System.out.println(MIN_VALUE);
		
		String x = toUnsignedString(5);
		
		System.out.println(Arrays.toString(args));
		
		String harry = args[2];
		
		System.out.println(harry);
		
		// a String IS-A CharSequence, so we can use an array of chars to instantiate it (constructor)
		char[] chars = { '1', '2', '3' };
		String str = new String(chars);
		
		System.out.println(str);
		
		// loop labels only exist while their "world" is still around
		// once we reach the end of the sample braces, it's not longer "alive"
		SAMPLE: for (int i = 0; i < 3; i++) {
			System.out.println(i);
			if (true) {
				break SAMPLE;
			}
		}
		
		// so this doesn't work
//		if (true)
//			break SAMPLE;
		
		int Math = 4;
		
		double y = java.lang.Math.random();
		
		String start = "abcdeabcde";
		
		start = start.replaceFirst("c", "C");
		
		System.out.println(start);
		
		start = start.replace('e', 'E');
		
		System.out.println(start);
		
		start = start.replaceAll("ab", "ABBA");
		
		System.out.println(start);

	}
	
	public static void infinite() {
		infinite();
	}
	
	// the first line inside is called a guard clause
	// it makes it so we don't have to type so many elses, etc.
	// we know, if we make it past the guard, that y is at least equal to, if not greater than, x
	// see the equals method below for three of these in a row
	public static int max (int x, int y) {
		if (x > y) return x;
		return y;
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EnthuwareReview other = (EnthuwareReview) obj;
		return value == other.value;
	}
	
	

}
