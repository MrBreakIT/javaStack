
public class Cards {

	private String suit;
	private String value;

	public Cards(String suit, String value) {
		this.suit = suit;
		this.value = value;

	}

	public String toString() {
		return value + " of " + suit;
	}

	public String getValue() {
		return value;
	}

	public String getSuit() {
		return suit;
	}

}
