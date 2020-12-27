package phones;

public class Galaxy extends Phone implements Ringable {
	public Galaxy(String versionNumber, String carrier, int batteryPercentage, String ringTone) {
		super(versionNumber, carrier, batteryPercentage, ringTone);
		this.batteryPercentage = 75;
		this.ringTone = "Ring Ring Ring";
	}

	@Override
	public String ringTone() {
		String output = "";
		output += "****************************************" + "\n";
		output += "Ring tone: " + ringTone + "\n";
		output += "Ring tone: " + ringTone + "\n";
		output += "Ring tone: " + ringTone + "\n";
		return output;
	}

	@Override
	public String unlock() {
		String output = "";
		output += "unlocking Galaxy via fingerprint scanner" + "\n";
		output += "Galaxy -" + versionNumber + "- " + this.getCarrier() + " BATTERY @ " + batteryPercentage + "%"
				+ "\n";
		output += "****************************************" + "\n";
		return output;
	}

	@Override
	public void displayInfo() {
		System.out.println(ringTone() + unlock());
	}
}
