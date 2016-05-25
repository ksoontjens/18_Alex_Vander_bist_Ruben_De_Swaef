/**
 * @author Alex Vanderbist
 */
public class Vermenigvuldiging {

	/**
	 * Main method
	 * @param arg[] Commandline arguments
	 */
	public static void main (String arg[]) {
		int x; int y;
		
		for(x = 1; x <= 9; x++) {
			for(y=1; y<=9; y++) {
				System.out.println(x + "x" + y + "=" + x*y);
			}
		}
	}
}