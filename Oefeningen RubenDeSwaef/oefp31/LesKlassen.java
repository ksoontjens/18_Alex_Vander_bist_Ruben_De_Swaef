//import org.kdg.personeel.*; //alle werknemer classes uit die onderliggende mappen
public class LesKlassen {

	public static void main(String args[])
	{
		//OEF 1 PAGINA 31
		Werknemer jan;
		jan = new Werknemer("Jan", "Janssens", 69, 420.0f);
		Werknemer herman = new Werknemer("Herman", "Swag", 2, 30.0f);
		Werknemer swaglex = new Werknemer("Swaglex", "McBooty", 5, 10.0f);
		Werknemer yolowuar = new Werknemer("Yolowuar", "Chillnado", 666, 15.0f);

		System.out.println(jan.voornaam + " verdient " + jan.getSalaris());
		System.out.println("aantal werknemers = " + Werknemer.aantalWerknemers);


		//OEF 2 
		jan.salarisVerhogen(10);
		System.out.println(jan.voornaam + " zijn nieuwe salaris is " + jan.getSalaris());
		herman.salarisVerhogen(20);
		System.out.println(herman.voornaam + " zijn nieuwe salaris is " + herman.getSalaris());

		//OEF 3 
		PartTimeWerknemer suzy = new PartTimeWerknemer("Suzy", "Wafel", 5, 20.5f, 24);
		PartTimeWerknemer swaggie = new PartTimeWerknemer("Swaggie", "Boogerballs", 13, 15.5f, 10);

		//OEF 4
		suzy.salarisVerhogen(4); //bij 10 een foutmelding
		System.out.println(suzy.voornaam + ",de Parttimewerkster, krijgt nu " + suzy.getSalaris());

		//OEF 5
		System.out.println(swaggie.voornaam + ",de Parttimewerker, heeft een RSZ van " + suzy.getRSZ());

		//OEF 7
		StudentWerknemer ruben = new StudentWerknemer("Ruben", "Swaffie", 10, 16.5f, 24);
		System.out.println(ruben.voornaam + ",de student, betaalt een RSZ van " + ruben.getRSZ() + " en krijgt " + ruben.getSalaris());

		//OEF 8
		//ruben.betaal();
		Factuur factuur1 = new Factuur(1,420.69f);
		Betaalbaar[] betDingen = new Betaalbaar[2];
		betDingen[0] = ruben;
		betDingen[1] = factuur1;
		for (int i =0; i<2; i++) {
			betDingen[i].betaal();
		}

	}
}