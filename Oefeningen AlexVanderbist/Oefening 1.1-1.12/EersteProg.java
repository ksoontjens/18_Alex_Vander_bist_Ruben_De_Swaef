/**
 * @author  Alex Vanderbist
 */
public class EersteProg {

	/**
	 * Dit is de main method
	 * @param arg[] Commandline argumenten
	 */
	public static void main(String arg[]) {
		drukaf(100);
	}

	/**
	 * Methode drukt getallen af tot m
	 * @param m tot hoeveel getallen worden er afgedrukt?
	 */
	private static void drukaf(int m) {
		int a;
		for(a=0; a<m;a++) {
			System.out.println(a);
		}
	}
}