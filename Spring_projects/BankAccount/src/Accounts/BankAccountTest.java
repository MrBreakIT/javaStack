package Accounts;

public class BankAccountTest {
	public static void main(String[] args) {
		BankAccount account1 = new BankAccount("Elon Musk");
		account1.toString();
		account1.makeDeposit("checking", 15000.25);
		account1.makeDeposit("savings", 2500.25);
		account1.checkAccounts();
		account1.makeWithdraw("checking", 1000.00);
		account1.checkAccounts();
		System.out.println(account1);

	}
}