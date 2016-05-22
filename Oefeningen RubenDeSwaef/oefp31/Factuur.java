public class Factuur implements Betaalbaar
{
	public float factuurbedrag = 0;
	public int factuurNr = 0;

	public Factuur(int factuurNr, float factuurbedrag)
	{
		this.factuurbedrag = factuurbedrag;
		this.factuurNr = factuurNr;
	}

	public void betaal()
	{
		System.out.println("Betaal factuur " + factuurNr + " van " + factuurbedrag);
	}
}