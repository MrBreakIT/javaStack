package Master;

public class Ninja extends Humans {
	private static Integer numberOfNinjas = 0;

	public Ninja(String name) {
		super(name);
		this.type = "Ninja";
		this.health = 500;
		this.strength = 100;
		this.stealth = 10;
		this.intel = 150;
		numberOfNinjas++;
	}

	public static Integer getNumberOfNinjas() {
		return numberOfNinjas;
	}

	public void steal(Humans player) {
		player.setHealth(player.getHealth() + this.intel);
		this.health += this.intel;
		System.out.println(this.name + " just stole " + this.intel + " health from " + player.name + "\n");
	}

	public void runAway() {
		this.health += -10;
		System.out.println(this.name + " had to leave mid-fight and lost 50 health. " + "\n");
	}
}
