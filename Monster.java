public abstract class Monster {
	public String name;
	public char team;
	public int health;
	public int power;

	/* Konstruktor */
	public Monster(String name, char team, int health, int power) {
		if(name != "") {
			this.name = name;
		}	
		else {
			System.out.printf("Sie haben keinen Namen eingegeben!%n");
			this.name = "";		
		}

		if(team != '\u0000') {
			this.team = team;		
		}
		else {
			System.out.printf("Sie haben keinen Team eingegeben!%n");
			this.team = 0;		
		}	
		this.health = health;
		this.power = power;
		System.out.printf("Es wurde das Monster %s erschaffen!%n", this.name);	
	}
	
	public String toString() {
		return "Name: " + this.name + ", Team: " + this.team + ", Lebensenergie: " 
		       + this.health + ", Kraft: " + this.power;	
	}

	/*
	* Abtrakte Methode attack
	* greift anderen Monster an
	* @param Monster other Anderes Monster
	*/
	public abstract void attack(Monster other);

	/*
	* Unterstuetzt das andere Monster
	* @param Monster other Anderes Monster
	*/
	public void support(Monster other) {
		System.out.printf("Der Unterstützer %s gafft nur!%n", this.name);	
	}
}
