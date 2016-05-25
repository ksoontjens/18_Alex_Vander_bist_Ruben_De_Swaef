package org.kdg.personeel;

public class StudentWerknemer extends PartTimeWerknemer {

	public StudentWerknemer(String voornaam, String achternaam, int nummer, float salaris, int urenPerWeek) 
	{
		super(voornaam, achternaam, nummer, salaris, urenPerWeek);
		setRSZ(5f);
	}

}