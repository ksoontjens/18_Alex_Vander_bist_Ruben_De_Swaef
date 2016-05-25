/**
 * @author Alex Vanderbist
 */
public class Negatief {

	/**
	 * Main method
	 * @param arg[] Commandline arguments
	 */
	public static void main (String arg[]) {
		int getal = 4302;
		int neggetal = ~getal;
		neggetal++;
		System.out.println(neggetal);
	}
}