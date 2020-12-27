import java.util.ArrayList;
import java.util.Collections;

public class Deck {

	private ArrayList<Cards> _deck;

	public Deck() {
		_deck = new ArrayList<Cards>();
		String[] suits = new String[] { "Spades", "Hearts", "Diamonds", "Clubs" };
		String[] values = new String[] { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };

		for (String suit : suits) {
			for (String value : values) {
				_deck.add(new Cards(suit, value));
			}
		}

	}

	public void shuffle() {
		Collections.shuffle(_deck);
	}

	public ArrayList<Cards> deal(int numberOfCards) {
		ArrayList<Cards> cards = new ArrayList<Cards>();
		while (numberOfCards > 0) {
			numberOfCards--;
			cards.add(_deck.get(0));
			_deck.remove(0);
		}
		return cards;
	}

	public static void main(String[] args) {
		Deck d1 = new Deck();
		System.out.println(d1._deck);
		d1.shuffle();
		System.out.println(d1._deck);
		ArrayList<Cards> player1 = d1.deal(13);
		ArrayList<Cards> player2 = d1.deal(13);
		ArrayList<Cards> player3 = d1.deal(13);
		ArrayList<Cards> player4 = d1.deal(13);
		System.out.println(d1._deck);
		System.out.println(player1);
		System.out.println(player2);
		System.out.println(player3);
		System.out.println(player4);
		System.out.println(player1.get(0).toString());
		System.out.println(player2.get(0).toString());
		System.out.println(player3.get(0).toString());
		System.out.println(player4.get(0).toString());
	}

}
