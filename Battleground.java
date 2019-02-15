class Battleground{
	public static void main(String[] args){
		System.out.println("Vorbereitung...");
		int NUM_MONSTER = 100;
		int SECONDS_SLEEP = 1;
		Monster[] monsters = new Monster[NUM_MONSTER];
		monsters[0] = new AxeThrowerTroll("Jaraxxus", 'A', 36, 1, 2, 2);
		monsters[1] = new Vampire("Vampy", 'C', 4, 2, 0);
		monsters[2] = new AxeThrowerTroll("Leeroy Jenkins", 'A', 1, 10,5,3);
		monsters[3] = new Vampire("Dracularius", 'B', 6, 2, 0);
		monsters[4] = new Troll("Trollopa", 'B', 2, 6, 1);
		monsters[5] = new Troll("Trolline", 'C', 8, 2, 1);
		monsters[6] = new Imp("Wichtelantius", 'C', 2, 4, 1);
		monsters[7] = new AxeThrowerTroll("Berserkerus", 'C', 3, 1, 1, 3);
		monsters[8] = new Imp("Wichtelontias", 'B', 2, 4, 1);	
		monsters[9] = new AxeThrowerTroll("Kukundi", 'C', 2, 2, 0, 1);

		// kaempfen
		System.out.println("Mögen die Spiele beginnen...");

		char winner = '\u0000';
		while(winner == '\u0000') { // kaempfen, bis ein Gewinner feststeht

			for (int i = 0; i < NUM_MONSTER; i++) { // jedes Monster ist mal aktiv

				if (monsters[i] == null) { // leere Arrayfelder ueberspringen
					continue;
				}
				// kurz warten
				try {
				    Thread.sleep(SECONDS_SLEEP*1000);
				} 
				catch(InterruptedException ex) {
				    Thread.currentThread().interrupt();
				}

				// entscheiden, ob angreifen oder Verbuendetem helfen (attack/support)
				boolean doAttack = Math.random()<0.5;

				if (doAttack == true) {

					// erstbesten Gegner suchen
					Monster enemy = null;
					for (int o = 0; o < NUM_MONSTER; o++) {
						if (monsters[o] == null) {
							continue;
						}
						// i == Idx aktives Monster, o == Idx Vergleichsmonster
						if (monsters[o].team != monsters[i].team) { 
							enemy = monsters[o];
							monsters[i].attack(enemy);
							if (enemy.health <= 0) {
								System.out.println(enemy.name + " ist am Ende seiner Kraefte. ");
								// Monster aus dem Array entfernen -> RIP
								monsters[o] = null; 
							}
							break;
						}
					}
					// schauen, ob es einen Gegner gab - wenn nicht haben wir gewonnen
					if (enemy == null) {
						System.out.println(monsters[i].name + " moechte angreifen, findet aber keinen Gegner mehr.");
						winner = monsters[i].team;
						break; 
					}

				} else { // if doAttack == false

					Monster ally = null;
					for (int o = 0; o < NUM_MONSTER; o++) {
						if (monsters[o] == null) {
							continue;
						}
						// i == Idx aktives Monster, o == Idx Vergleichsmonster
						if (monsters[o].team == monsters[i].team && o != i) { 
							ally = monsters[o];
							monsters[i].support(ally);
						}
						if (ally != null) {
							break;
						}
					}
					// schauen, ob es einen Verbuendeten gab - wenn nicht verzweifelt gucken
					if (ally == null) {
						System.out.println(monsters[i].name + " sieht keinen Verbuendeten mehr und ist am verzweifeln.");
					}
				}
			}
		}
		System.out.println("");
		System.out.println("Es gewinnt das Team " +winner + ".");
		System.out.println("");
		System.out.println("Sieger:");
		for (int i = 0; i < NUM_MONSTER; i++) {
			if (monsters[i] == null) {
				continue;
			}
			System.out.println(monsters[i]);
		}
	}
}