package phones;

public class IPhone extends Phone implements Ringable {
	public IPhone(String versionNumber, String carrier, int batteryPercentage, String ringTone) {
		super(versionNumber, carrier, batteryPercentage, ringTone);
		this.batteryPercentage = 27;
		this.ringTone = "Zing Zing Zing";
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
		output += "unlocking IPhone via facial recognition" + "\n";
		output += "IPhone -" + versionNumber + "- " + this.getCarrier() + " BATTERY @ " + batteryPercentage + "%"
				+ "\n";
		output += "****************************************" + "\n";

		return output;
	}

	@Override
	public void displayInfo() {
		System.out.println(ringTone() + unlock());
	}
}
