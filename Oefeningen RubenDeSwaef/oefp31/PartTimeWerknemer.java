//package org.kdg.personeel;
public class PartTimeWerknemer extends Werknemer{

	int urenPerWeek;

	public PartTimeWerknemer(String voornaam, String achternaam, int werknemerNummer, float salaris, int uren)
	{
		super(voornaam, achternaam, werknemerNummer, salaris); //MOET OP EERSTE LIJN
		urenPerWeek = uren;
	}

	public void salarisVerhogen(int percentage) 
	{
		//overloaden is parameter toevoegen, overschrijven is zelfde parameters
		if (percentage>5) {
			System.err.println("FOUT: PartTimeWerknemers kunnen slechts 5x opslag krijgen");
		}
		else
		{
			super.salarisVerhogen(percentage);
		}

	}
}