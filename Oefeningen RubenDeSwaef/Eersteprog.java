public class Eersteprog {

	/**
	*Dit is de main methode
	* @param arg[] is een parameter die met cmd meekomt
	*/

	public static void main (String arg[])
	{
		int a;
		int b;
		a=0314; //0 vanvoor grondtal=8
		System.out.println(a); //geeft 204

		System.out.println("Hello World: " + arg[0]);
		
		boolean x;
		if (a!=5) {
			x=true;
		}

		b = a++;
		a*=5;

		System.out.println(~10); //GEEFT -11
		//waarom? ~ inverteert alle bits van het getal > bits inverteren +1 = modulus -x
		//~x+ = -x
		
	}

}