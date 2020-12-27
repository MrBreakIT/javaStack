package phones;

public abstract class Phone {
	public String versionNumber;
	public int batteryPercentage;
	public String carrier;
	public String ringTone;

	public Phone(String versionNumber, String carrier, int batteryPercentage, String ringTone) {
		this.versionNumber = versionNumber;
		this.batteryPercentage = 100;
		this.carrier = carrier;
		this.ringTone = ringTone;
	}

	public String getVersionNumber() {
		return versionNumber;
	}

	public void setVersionNumber(String versionNumber) {
		this.versionNumber = versionNumber;
	}

	public int getBatteryPercentage() {
		return batteryPercentage;
	}

	public void setBatteryPercentage(int batteryPercentage) {
		this.batteryPercentage = batteryPercentage;
	}

	public String getCarrier() {
		return carrier;
	}

	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}

	public String getRingTone() {
		return ringTone;
	}

	public void setRingTone(String ringTone) {
		this.ringTone = ringTone;
	}

	public String unlock() {
		String output = "";
		output += "****************************************" + "\n";
		output += "***** unlocking Phone via pass code ******" + "\n";
		output += "Phone  " + this.getCarrier() + versionNumber + " BATTERY @ " + batteryPercentage + " % " + " "
				+ "\n";
		output += "****************************************" + "\n";

		return output;
	}

	public void displayInfo() {
		System.out.println(ringTone() + unlock());
	}

	public String ringTone() {
		String output = "";
		output += "Ring tone " + ringTone + "\n";
		output += "Ring tone " + ringTone + "\n";

		return output;
	}
}
