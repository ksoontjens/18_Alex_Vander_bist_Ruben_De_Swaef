//package org.kdg.personeel;
public class StudentWerknemer extends PartTimeWerknemer{


	public StudentWerknemer(String voornaam, String achternaam, int werknemerNummer, float salaris, int uren)
	{
		super(voornaam, achternaam, werknemerNummer, salaris, uren); //MOET OP EERSTE LIJN
		setRSZ(5.0f);
	}
}