package Master;

public class Wizard extends Humans {
	private static Integer numberOfWizards = 0;

	public Wizard(String name) {
		super(name);
		this.type = "Wizard";
		this.strength = 100;
		this.intel = 10;
		this.stealth = 10;
		this.health = 50;
		numberOfWizards++;
	}

	public static Integer getNumberOfWizards() {
		return numberOfWizards;
	}

	public void healHuman(Humans player) {
		System.out.println(this.name + " just healed " + player.name + " and health increased by " + this.intel + "\n");
	}

	public void fireball(Humans player) {
		player.setHealth(player.getHealth() - this.intel);
		System.out.println(
				this.name + " shot a fireball at " + player.name + " and dealt " + this.intel + " damage " + "\n");
	}
}
