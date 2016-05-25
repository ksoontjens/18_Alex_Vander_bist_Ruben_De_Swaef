import org.kdg.personeel.*;

class LesKlassen {

	public static void main (String[] args) {

		Werknemer[] werknemers = new Werknemer[6];

		werknemers[0] = new Werknemer("Jan", "Janssens", 1, 20.0f);
		werknemers[1] = new Werknemer("Niet Jan", "Janssens", 2, 20.0f);
		werknemers[2] = new Werknemer("Mark", "Davids", 3,80.0f);
		werknemers[3] = new Werknemer("NietMark", "Davids", 4,80.0f);
		werknemers[4] = new PartTimeWerknemer("Suzy", "Pizza", 5, 50.0f, 12);
		werknemers[5] = new StudentWerknemer("George", "Lucas", 6, 10.0f, 55);

		werknemers[2].salarisVerhogen(10);
		werknemers[4].salarisVerhogen(10);

		werknemers[1].setRSZ(44f);
		werknemers[4].setRSZ(30f);

		for (int i = 0; i < werknemers.length; i++) {
			System.out.println(werknemers[i].voornaam + " verdient " + werknemers[i].getSalaris() + ". RSZ: " + werknemers[i].getRSZ());
			werknemers[i].betaal();
		}

		System.out.println();

		Factuur fact = new Factuur(1337, 13.37f);
		fact.betaal();
	}
}