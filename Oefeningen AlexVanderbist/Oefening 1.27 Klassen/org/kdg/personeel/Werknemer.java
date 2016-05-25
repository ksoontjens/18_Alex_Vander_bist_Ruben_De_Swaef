package org.kdg.personeel;
/**
 * @author Alex Vanderbist
 */
public class Werknemer implements Betaalbaar {
	public     String  voornaam;
	public     String  achternaam;
	public     int     nummer;
	protected  float   salaris;
	private	   float   rszPercentage = 33.0f;

	public static int aantalWerkenemers;

	public Werknemer (String voornaam, String achternaam, int nummer, float salaris) {
		this.voornaam   = voornaam;
		this.achternaam = achternaam;
		this.nummer     = nummer;
		this.salaris    = salaris;

		this.aantalWerkenemers++;
	}

	public float getRSZ() {
		return this.rszPercentage;
	}

	public void setRSZ(float rsz) {
		this.rszPercentage = rsz;
	}

	public void salarisVerhogen(int percentage) {
		this.salaris = this.salaris * (1+(percentage / 100f));
	}

	public float getSalaris() {
		return this.salaris;
	}

	public void betaal() {
		System.out.println("Betaal " + this.voornaam + " " + this.salaris+ "EUR");
	}
}