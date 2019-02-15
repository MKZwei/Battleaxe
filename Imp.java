public class Imp extends Monster {
	public int mana;

	public Imp(String name, char team, int health, int power, int mana) {
		super(name, team, health, power);
		this.mana = mana;
	}

	/* @override */
	public void attack(Monster other) {
		if(this.mana >= 2) {
			int schaden = 3 * this.power;
			this.mana -= 2;	
			System.out.printf("Der Imp %s hat %s mit einem Feuerball einen Schaden von %d angefügt.%n",
					  this.name, other.name, schaden);	
		}
		else {	
			System.out.printf("Der Troll %s hat für einen Feuerball noch zu wenig mana. Mana: %d%n",
					  this.name, this.mana);
			++this.mana;		
		}
	}

	/* @override */
	public void support(Monster other) {
		int heilung = 0;
		if(this.mana >= 1) {
			if(other instanceof Imp) {
				heilung = 2 * this.power;
				other.health += heilung;
				++((Imp)other).mana;
				--this.mana;
				System.out.printf("Der Imp %s hat seinen Artgenossen %s auf eine Lebensenrgie von %d geheilt.%nDas mana von %s beträgt %d, und das von %s %d%n", this.name
						  , other.name, other.health, this.name, this.mana, other.name, ((Imp)other).mana);			
			}
			else {
				heilung = 2 * this.power; 
				other.health += heilung;
				--this.mana;
				System.out.printf("Der Imp %s hat seinen %s auf eine Lebensenrgie von %d geheilt.%nSein mana beträgt nun %d%n",
						  this.name, other.name, other.health, this.mana);
			}		
		}	
	}

	/* @override */
	public String toString() {
		return super.toString() + ", mana: " + this.mana + "\n";	
	}
}
