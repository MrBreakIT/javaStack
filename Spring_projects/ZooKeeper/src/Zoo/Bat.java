package Zoo;

public class Bat extends Mammal {
	public Bat(String name, String type, int energyLevel) {
		super(name, type, energyLevel);
		this.canFly = true;
		this.eatHumans = true;
		this.attackTowns = true;
		this.throwSomething = false;
		this.eatBananas = false;
		this.canClimb = false;
	}

	public void allDay() {
		System.out.println("********************");
		attackTowns();
		attackTowns();
		attackTowns();
		eatHuman();
		eatHuman();
		canFly();
		canFly();
		eatHuman();
		eatHuman();
		eatHuman();
		eatHuman();
		eatHuman();
		eatHuman();
		System.out.println("********************");
	}

}
