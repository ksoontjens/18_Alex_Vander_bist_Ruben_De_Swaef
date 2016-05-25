/**
 * @author Alex Vanderbist
 */
public class Priemgetallen {

	/**
	 * Main method
	 * @param arg[] Commandline arguments
	 */
	public static void main (String arg[]) {
		boolean deler = false;
		for(int i=3; i<=99; i++) {

			deler = false;
			for(int j=2; j<i; j++) {
				if(i % j == 0) {
					// er is een deler; niet printen
					deler = true;
				}
			}

			if(deler == false) System.out.print(i + ", ");
		}
	}
}