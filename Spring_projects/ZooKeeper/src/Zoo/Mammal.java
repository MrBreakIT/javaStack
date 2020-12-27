package Zoo;

public class Mammal {

	public String name;
	public String type;
	public Integer energyLevel;
	public Boolean throwSomething;
	public Boolean eatBananas;
	public Boolean canClimb;
	public Boolean canFly;
	public Boolean eatHumans;
	public Boolean attackTowns;

	public Mammal(String name, String type, int energyLevel) {
		this.name = name;
		this.type = type;
		this.energyLevel = energyLevel;
	}

	public Mammal() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;

	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getEnergyLevel() {
		return energyLevel;
	}

	public void setEnergyLevel(Integer energyLevel) {
		this.energyLevel = energyLevel;
	}

	public Boolean getThrowSomething() {
		return throwSomething;
	}

	public void setThrowSomething(Boolean throwSomething) {
		this.throwSomething = throwSomething;
	}

	public Boolean getEatBananas() {
		return eatBananas;
	}

	public void setEatBananas(Boolean eatBananas) {
		this.eatBananas = eatBananas;
	}

	public Boolean getCanClimb() {
		return canClimb;
	}

	public void setCanClimb(Boolean canClimb) {
		this.canClimb = canClimb;
	}
//	****************************** <Bat Getters> **********************************************
	public Boolean getCanFly() {
		return canFly;
	}

	public void setCanFly(Boolean canFly) {
		this.canFly = canFly;
	}

	public Boolean getEatHumans() {
		return eatHumans;
	}

	public void setEatHumans(Boolean eatHumans) {
		this.eatHumans = eatHumans;
	}

	public Boolean getAttackTowns() {
		return attackTowns;
	}

	public void setAttackTowns(Boolean attackTowns) {
		this.attackTowns = attackTowns;
	}

	public String toString() {
		String output = "";
		output += "Name:           " + name + "\n";
		output += "Type:           " + type + "\n";
		output += "Energy Level:   " + energyLevel + "\n";
		output += "Can Throw?      " + (throwSomething ? "yes" + "\n" : "no" + "\n");
		output += "Eats Bananas?   " + (eatBananas ? "yes" + "\n" : "no" + "\n");
		output += "Can Climb?      " + (canClimb ? "yes" + "\n" : "no" + "\n");
		output += "Can Fly?        " + (canFly ? "yes" + "\n" : "no" + "\n");
		output += "Eats Humans?    " + (eatHumans ? "yes" + "\n" : "no" + "\n");
		output += "Attacked Town?  " + (attackTowns ? "yes" + "\n" : "no" + "\n");
		
		return output;

	}
//	********************************** <Gorilla actions> ******************************************************
	public void throwSomething() {
		if (getThrowSomething() == true) {
			energyLevel += -5;
			System.out.println(name + ": Threw something and lost 5 energy." + "\n");
		}
	}

	public void eatBananas() {
		if (getEatBananas() == true) {
			energyLevel += 10;
			System.out.println(name + ": Just ate bananas and regained 10 energy" + "\n");
		}
	}

	public void canClimb() {
		if (getCanClimb() == true) {
			energyLevel += -10;
			System.out.println(name + ": Just climbed and lost 10 energy" + "\n");
		}
	}
//	********************************** <Bat actions> ************************************************************
	public void canFly() {
		if (getCanFly() == true) {
			energyLevel += -50;
			System.out.println(name + ": Just flew and lost 10 energy" + "\n");
		}
	}
	public void eatHuman() {
		if (getEatHumans() == true) {
			energyLevel += 25;
			System.out.println(name + ": Just ate a human and gained 50 energy" + "\n");
		}

	}
	public void attackTowns() {
		if (getAttackTowns() == true) {
			energyLevel += -100;
			System.out.println(name + ": Just attacked a town and gained 10 energy" + "\n");
		}

	}


	
}















