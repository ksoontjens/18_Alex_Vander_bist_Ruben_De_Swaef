public class Factuur implements Betaalbaar {
	public int nummer;
	public float bedrag;

	public Factuur(int nummer, float bedrag) {
		this.nummer = nummer;
		this.bedrag = bedrag;
	}

	public void betaal() {
		System.out.println("Betaal het factuur " + this.nummer + " voor een bedrag van " + this.bedrag);
	}
}