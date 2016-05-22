// //package groepeert klasses, packagenaam komt overeen me mappenstructuur
public class Werknemer implements Betaalbaar{ //blz 21

	public String voornaam;
	public String achternaam;
	public int werknemerNr;
	protected float salaris;
	private float rszpercentage=33.0f;

	public static int aantalWerknemers;


	public Werknemer(String voornaam, String achternaam, int werknemerNummer, float salaris)
	{
		this.voornaam=voornaam;
		this.achternaam=achternaam;
		werknemerNr=werknemerNummer;
		this.salaris=salaris;

		aantalWerknemers++;
	}
	public void salarisVerhogen(int percentage)
	{
		salaris=salaris * (1+(percentage/100.0f)); 
	}
	public float getSalaris()
	{
		return salaris;
	}
	float getRSZ() {
		return rszpercentage;
	}
	void setRSZ(float rsz){
		rszpercentage = rsz;
	}
	public void betaal() { //IMPLEMENTS BETAALBAAR
		System.out.println("Betaal " + salaris + " aan " + voornaam);
	}
}