class Vampire extends Monster {
	public int age;
	public Vampire (String name, char team, int health, int power, int age){
		super(name, team, health, power);
		this.age = age;
	}

	// fuegt dem Angreifer Schaden in Hoehe seiner Power + Alter	
	// nach jedem Angriff alter +1 und health +1
	public void attack(Monster other){
		// Schaden ausrechnen
		int damage = this.power+this.age;

		// anderes Monster angreifen
		other.health -= damage;
		System.out.print(this.name + " beisst ");
		System.out.print(other.name + " an und verursacht ");
		System.out.print(damage + " Schaden ");
		System.out.println(", heilt sich um 1 Gesundheit und altert um 1.");
		this.health++;
		this.age++;
	}

	// public void support(Monster other) - keine support-Faehigkeit
	
	
	public String toString(){
		return super.toString() + " age=\""+this.age+"\"";
	}
}