package org.kdg.personeel;

public class PartTimeWerknemer extends Werknemer {

	public int urenPerWeek;
	
	public PartTimeWerknemer(String voornaam, String achternaam, int nummer, float salaris, int urenPerWeek) {
		super(voornaam, achternaam, nummer, salaris);
		this.urenPerWeek = urenPerWeek;

	}

	public void salarisVerhogen(int percentage) {
		if(percentage > 5) {
			System.err.println("Partime werknemer kunnen niet meer dan 5 procent krijgen");
		} else {
			super.salarisVerhogen(percentage);
		}
	}

}