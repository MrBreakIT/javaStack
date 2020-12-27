package Zoo;

public class Gorilla extends Mammal {
	public Gorilla(String name, String type, int energyLevel) {
		super(name, type, energyLevel);
		this.throwSomething = true;
		this.eatBananas = true;
		this.canClimb = true;
		this.canFly = false;
		this.eatHumans = false;
		this.attackTowns = false;
	}

	public void allDay() {
		System.out.println("********************");
		throwSomething();
		throwSomething();
		throwSomething();
		eatBananas();
		eatBananas();
		canClimb();
		System.out.println("********************");
	}

}
