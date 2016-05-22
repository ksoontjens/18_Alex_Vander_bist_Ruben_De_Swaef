/**
* Dit is een oefening
* @author Ruben De Swaef
*/
public class oef1{

	/**
	* Dit is de main methode
	* @param args[] Dit zijn de parameters die met de commandline meekomen
	*/
	public static void main(String args[])
	{
		drukaf(100);
	}

	/**
	* Deze methode drukt de getallen af tot m
	* @param m Deze parameter geeft aan tot hoevee lde methode afdrukt
	*/
	public static void drukaf(int m)
	{
		int a;
		for (a=0;a<m;a++)
		{
			System.out.println(a);
		}
	}
}