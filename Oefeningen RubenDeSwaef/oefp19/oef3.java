public class oef3 {

	public static void main(String arg[])
	{
		float pi;
		float pinum = 0;
		float x;
		for (x=1;x<=10000;x=x+4) {
			pinum = pinum + (1/x) - (1/(x+2));
			
		}
		pi = 4*pinum;
		System.out.println(pi);

	}
}