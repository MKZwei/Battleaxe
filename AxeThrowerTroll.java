public class AxeThrowerTroll extends Troll {
	public int numAxes;
	
	public AxeThrowerTroll(String name, char team, int health, int power, int armor, int numAxes) {
		super(name, team, health, power, armor);
		this.numAxes = numAxes;		
	}
	
	/* override */
	public void attack(Monster other) {
		if(this.numAxes > 0) {
			int schaden = 3 * this.power;
			other.health -= schaden;
			--this.numAxes;	
			System.out.printf("Der Troll %s hat %s durch einen Axtwurf einen Schaden von %d angefügt.%n",
					  this.name, other.name, schaden);	
		}
		else {
			super.attack(other);
		}		
	} 
	/* @override */
	public void support(Monster other) {
		++other.power;
		System.out.printf("Axttroll %s hat mit einem Schrei die energie von %s auf %d erhöht.%n", this.name
				  , other.name, other.power);
	}

	/* @override */
	public String toString() {
		return super.toString() + ", Anzahl Aexte: " + this.numAxes + "\n";	
	}
}
