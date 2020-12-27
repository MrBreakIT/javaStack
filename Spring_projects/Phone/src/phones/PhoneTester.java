package phones;

public class PhoneTester {
	public static void main(String[] args) {
		Galaxy s9 = new Galaxy("S9", "Verizon", 99, "Ring, Ring, Ring!");
		IPhone iphoneTen = new IPhone("X", "AT&T", 100, "Zing");

		s9.displayInfo();
		System.out.println(s9.ringTone());
		System.out.println(s9.unlock());

		iphoneTen.displayInfo();
		System.out.println(iphoneTen.ringTone());
		System.out.println(iphoneTen.unlock());

	}
}
