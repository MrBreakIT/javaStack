package Master;

public class HumansTest {
	public static void main(String[] args) {
		Humans player1 = new Humans("Daniel Larusso");
		Humans player2 = new Humans("Johnny Lawrence");
		Ninja player3 = new Ninja("Hatsumi");
		Samurai player4 = new Samurai("Abe Masakatsu");
		Wizard player5 = new Wizard("Agorim");

		player1.toString();
		player2.toString();
		player3.toString();
		player4.toString();
		player5.toString();
		System.out.println(player1);
		System.out.println(player2);
		System.out.println(player3);
		System.out.println(player4);
		System.out.println(player5);

		player1.attack(player2);
		player3.steal(player2);
		player5.fireball(player3);
		player4.meditate(player4);
		player3.runAway();
		player4.deathBlow(player1);
		player5.fireball(player4);

		System.out.println(player1);
		System.out.println(player2);
		System.out.println(player3);
		System.out.println(player4);
		System.out.println(player5);

	}

}
