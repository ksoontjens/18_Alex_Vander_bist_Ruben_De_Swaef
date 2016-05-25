/**
 * @author Alex Vanderbist
 */
public class Pi {

	/**
	 * Main method
	 * @param arg[] Commandline arguments
	 */
	public static void main (String arg[]) {
		double pi = 0d;
		boolean plusOrMinus = true;

		for(int i=1; i<10000; i+=2) {

			if(plusOrMinus) pi += (1d / i);
			else pi -= (1d/i);

			plusOrMinus = !plusOrMinus;
		}
		
		pi *= 4d;
		System.out.println(pi);
	}
}