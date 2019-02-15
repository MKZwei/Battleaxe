public class Troll extends Monster {
	public int armor;

	public Troll(String name, char team, int health, int power, int armor) {
		super(name, team, health, power);
		this.armor = armor;	
	}

	/* @override */
	public void attack(Monster other) {
		int schaden = 2 * this.power - this.armor;
		if(schaden <= 0) schaden = 1;
		other.health -= schaden;
		System.out.printf("Der Troll %s hat %s einen Schaden von %d angefügt.%n", this.name, other.name, schaden);	
	}	
	
	/* @override*/
	public String toString() {
		return super.toString() + ", Ruestung: " + this.armor + "\n";	
	}
}
