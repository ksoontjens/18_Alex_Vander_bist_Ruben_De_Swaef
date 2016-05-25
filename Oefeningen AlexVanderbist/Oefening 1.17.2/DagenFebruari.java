/**
 * @author Alex Vanderbist
 */
public class DagenFebruari {

	/**
	 * Main method
	 * @param arg[] Commandline arguments
	 */
	public static void main (String arg[]) {
		int weekday = 0;
		String daystring = "";
		for(int x = 1; x <= 28; x++) {
			switch (weekday) {
				case 0: daystring = "maandag";
					break;
				case 1: daystring = "dinsdag";
					break;
				case 2: daystring = "woensdag";
					break;
				case 3: daystring = "donderdag";
					break;
				case 4: daystring = "vrijdag";
					break;
				case 5: daystring = "zaterdag";
					break;
				case 6: daystring = "zondag";
					break;
			}
			weekday++;
			if(weekday > 6) weekday = 0;
			System.out.println(daystring + " " + x + " februari 2009");
		}
	}
}