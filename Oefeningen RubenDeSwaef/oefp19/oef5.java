public class oef5 {

	public static void main(String arg[])
	{
		float x;
		float d;
		int priem;
		for (x=3; x<=100; x++) 
		{
			priem = 0;
			for (d=-1; d<=2; d++) 
			{
				if(x%d!=0)
				{
					priem++;
				}
			}
			if (priem == 2) {
				System.out.println(x);
			}
		}
	}

}