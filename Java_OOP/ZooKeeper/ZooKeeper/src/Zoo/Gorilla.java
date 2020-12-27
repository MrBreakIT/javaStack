package Zoo;

public class Gorilla extends Mammal {
	public Gorilla(String name, String type, int energyLevel) {
		super(name, type, energyLevel);
		this.throwSomething = true;
		this.eatBananas = true;
		this.canClimb = true;
	}

	public void allDay() {
		System.out.println("********************");
		throwSomething();
		eatBananas();
		canClimb();
		System.out.println("********************");
	}

}
