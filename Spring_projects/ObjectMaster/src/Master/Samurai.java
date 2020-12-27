package Master;

public class Samurai extends Humans {
	private static Integer numberOfSamurai = 0;

	public Samurai(String name) {
		super(name);
		this.type = "Samurai";
		this.health = 200;
		this.strength = 100;
		this.stealth = 250;
		this.intel = 150;
		numberOfSamurai++;
	}

//	add method deathBlow attacks object(Human) and decrease (Human) health to 0; BUT reduces Samurai health by half
//  add method meditate heals Samurai for half of current health
//	add method howMany returns total current number of Samurai	

	public static Integer getNumberOfSamurai() {
		return numberOfSamurai;
	}

	public void deathBlow(Humans player) {
		player.setHealth(player.getHealth() - player.getHealth());
		this.health = this.health / 2;
		System.out.println(this.name + " landed death-blow and destroyed " + player.name + " but took "
				+ this.health / 2 + " damage." + "\n");
	}

	public void meditate(Humans player) {
		this.health += this.health / 2;
		System.out.println(this.name + " meditated and restored " + this.health / 2 + " health " + "\n");

	}
}
