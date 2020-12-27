package Accounts;

import java.util.Random;

public class BankAccount {
	protected String name;
	protected String accountNumber;
	protected Double CheckingBal;
	protected Double SavingsBal;
	private Double TotalAcctBal = 0.00;
	private Integer numOfBankAccounts = 0;

	public BankAccount(String name) {
		this.name = name;
		this.accountNumber = accountNumber();
		this.CheckingBal = 0.00;
		this.SavingsBal = 0.00;

		numOfBankAccounts++;
	}

	private String accountNumber() {

		String aBC = "1234567890";
		Random rand = new Random();
		String accountNumber = "";
		String temp = "";
		for (int j = 0; j < 10; j++) {
			temp += aBC.charAt(rand.nextInt(5));
		}
		accountNumber = temp;

		return accountNumber;
	}

	public String toString() {
		String output = "";
		output += "Name:                 " + name + "\n";
		output += "Account Number:       " + accountNumber + "\n";
		output += "Checking Bal:         $ " + CheckingBal + "\n";
		output += "Savings Bal:          $ " + SavingsBal + "\n";

		return output;
	}

	public void checkAccounts() {
		System.out.println("*****************************************************" + "\n" + "Welcome " + this.name
				+ " looks like you have $" + this.CheckingBal + " in your checking account " + "\n" + "You also have $"
				+ this.SavingsBal + " in your savings account today." + "\n"
				+ "*****************************************************");
	}

	public void makeDeposit(String checking, Double money) {
		if (checking == "checking") {
			this.CheckingBal += money;
			TotalAcctBal += money;
			System.out.println("*****************************************************" + "\n" + "Welcome " + this.name
					+ " looks like you have deposited $" + money + " into your checking account. Your balance is: $"
					+ this.CheckingBal + "\n" + "*****************************************************");
		} else {
			this.SavingsBal += money;
			TotalAcctBal += money;
			System.out.println("*****************************************************" + "\n" + "Welcome " + this.name
					+ " looks like you have deposited $" + money
					+ " into your savings account. Your savings balance is: $" + this.SavingsBal + "\n"
					+ "*****************************************************");
		}

	}

	public void makeWithdraw(String account, Double money) {
		if (account == "savings") {
			Double temp = (this.SavingsBal - money);
			if (temp < 0) {
				System.out.println("*****************************************************" + "\n" + "Sorry, "
						+ this.name + " you do not have the funds to complete this transaction " + this.SavingsBal
						+ "\n" + "*****************************************************");
			} else {
				this.SavingsBal += -money;
				TotalAcctBal += -money;
				System.out.println("*****************************************************" + "\n" + "Welcome "
						+ this.name + " looks like you have withdrew " + money
						+ "$ from your savings account. Your balance is: $" + this.SavingsBal + "\n"
						+ "*****************************************************");
			}

		} else {
			Double temp = (this.CheckingBal += -money);
			if (temp > 0) {
				System.out.println("*****************************************************" + "\n" + "sorry " + this.name
						+ " you do not have the funds to complete this transaction $" + this.CheckingBal + "\n"
						+ "*****************************************************");
			} else {
				this.CheckingBal += -money;
				TotalAcctBal += -money;
				System.out.println("*****************************************************" + "\n" + "Welcome "
						+ this.name + " looks like you have withdrew $" + money
						+ " from your checking account. Your balance is: $" + this.CheckingBal + "\n"
						+ "*****************************************************");
			}
		}

	}

//	create a transfer funds method from checking to savings and vice versa.

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Double getCheckingBal() {
		return CheckingBal;
	}

	public void setCheckingBal(Double checkingBal) {
		CheckingBal = checkingBal;
	}

	public Double getSavingBal() {
		return SavingsBal;
	}

	public void setSavingBal(Double savingBal) {
		SavingsBal = savingBal;
	}

	public Double getTotalAcctBal() {
		return TotalAcctBal;
	}

	public void setTotalAcctBal(Double totalAcctBal) {
		TotalAcctBal = totalAcctBal;
	}

	public Integer getNumOfBankAccounts() {
		return numOfBankAccounts;
	}

	public void setNumOfBankAccounts(Integer numOfBankAccounts) {
		this.numOfBankAccounts = numOfBankAccounts;
	}

//	methods needed- deposit check, check the balance, withdraw funds

}
