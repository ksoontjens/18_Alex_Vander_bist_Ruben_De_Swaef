public class oef6 {

	public static void main(String arg[])
	{
		int a[] = {12,34,56,78,123,234,99,88};
		int biggest = 0;
		int x;
		for (x=0; x<a.length; x++) 
		{
			if (a[x]>biggest) {
				biggest = a[x];
			}
		}
		System.out.println(biggest);
	}

}