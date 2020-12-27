package rpg;

import java.util.Scanner;

public class SayUncle {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String userInput = "";

		while (!userInput.equals("uncle")) {
			System.out.println("Say Uncle!!!");
			userInput = input.nextLine();
		}
		System.out.println("Ok, done.");
	}
}
