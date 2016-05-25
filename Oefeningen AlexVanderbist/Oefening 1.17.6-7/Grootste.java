/**
 * @author Alex Vanderbist
 */
public class Grootste {

	/**
	 * Main method
	 * @param arg[] Commandline arguments
	 */
	public static void main (String arg[]) {
		int[] numbers = {12,34,56,78,123,234,99,88};
		int biggestInt = 0;

		for (int i=0; i<numbers.length; i++) {
			if(numbers[i] > biggestInt) biggestInt = numbers[i];
		}

		System.out.println("Grootste nummer is " + biggestInt);
	}
}