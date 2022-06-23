package bank_account;

public class BankAccount {
	private double checkingBalance;
	private double savingsBalance;
	private static int numOfAccounts;
	private static double totalMoney;
	
	public BankAccount(double checkDeposit, double saveDeposit) {
		this.checkingBalance = checkDeposit;
		this.savingsBalance = saveDeposit;
		numOfAccounts++;
		totalMoney = totalMoney + checkDeposit + saveDeposit;
	}
	
	public double getCheckingBal() {
		return this.checkingBalance;
	}
	
	public double getSavingsBal() {
		return this.savingsBalance;
	}
	
	public String deposit(double amount, String account) {
		if(account == "Checking") {
			this.checkingBalance = this.checkingBalance + amount;
			totalMoney = totalMoney + amount;
			return String.format("You deposited %f into your checking account", amount);
		} else {
			this.savingsBalance = this.savingsBalance + amount;
			totalMoney = totalMoney + amount;
			return String.format("You deposited %f into your savings account", amount);
		}
		
	}
	
	public String withdraw(double amount, String account) {
		if(account == "Checking") {
			if(this.checkingBalance - amount < 0) {
				return "Insufficent funds";
			} else {
				this.checkingBalance = this.checkingBalance - amount;
				totalMoney = totalMoney - amount;
				return String.format("You took %f out of your checking account", amount);
			}
			
		} else {
			if(this.savingsBalance - amount < 0) {
				return "Insufficent funds";
			}
			this.savingsBalance = this.savingsBalance - amount;
			totalMoney = totalMoney - amount;
			return String.format("You took %f out of your savings", amount);
		}
	}
	
	public String getBal() {
		return String.format("Your checking Balance is: %f. Your savings balance is: %f", this.checkingBalance, this.savingsBalance);
	}
	
	public String getTotalMoney() {
		return String.format("The Total money in the bank is: %f", totalMoney);
	}

}
