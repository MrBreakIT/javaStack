package Master;

public class Humans {

	private static Integer numberOfHumans = 0;
	public String name;
	public String type;
	public Integer strength;
	public Integer intel;
	public Integer stealth;
	public Integer health;
	public Boolean attack;

	public Humans(String name) {
		this.name = name;
		this.type = "Human";
		this.strength = 3;
		this.intel = 3;
		this.stealth = 3;
		this.health = 100;
		this.attack = true;
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

	public Integer getStrength() {
		return strength;
	}

	public void setStrength(Integer strength) {
		this.strength = strength;
	}

	public Integer getIntel() {
		return intel;
	}

	public void setIntel(Integer intel) {
		this.intel = intel;
	}

	public Integer getStealth() {
		return stealth;
	}

	public void setStealth(Integer stealth) {
		this.stealth = stealth;
	}

	public Integer getHealth() {
		return health;
	}

	public void setHealth(Integer health) {
		this.health = health;
	}

	public Boolean getAttack() {
		return attack;
	}

	public void setAttack(Boolean attack) {
		this.attack = attack;
	}

//	****************** < Output to String> *********************
	public String toString() {
		String output = "";
		output += "Name:                " + name + "\n";
		output += "Type:                " + type + "\n";
		output += "Strength:            " + strength + "\n";
		output += "Intel:               " + intel + "\n";
		output += "Stealth:             " + stealth + "\n";
		output += "Health:              " + health + "\n";
		output += "Can Attack:          " + (attack ? "yes" + "\n" : "\n");
		return output;
	}

//********************* < attack methods> **************************
	public void attack(Humans player) {
		player.setHealth(player.getHealth() - this.strength);
		System.out.println(
				this.name + " just attacked " + player.name + " and dealt " + this.strength + " damage" + "\n");
	}

}
