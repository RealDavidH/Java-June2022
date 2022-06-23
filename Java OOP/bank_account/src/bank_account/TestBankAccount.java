package bank_account;

public class TestBankAccount {

	public static void main(String[] args) {
		BankAccount user1 = new BankAccount(100, 100.5);
		
		System.out.println(user1.getCheckingBal());
		System.out.println(user1.getSavingsBal());
		System.out.println(user1.deposit(400, "Checking"));
		System.out.println(user1.getTotalMoney());
		System.out.println(user1.deposit(400, "Savings"));
		System.out.println(user1.withdraw(500, "Checking"));
		System.out.println(user1.withdraw(200, "Savings"));
		System.out.println(user1.getTotalMoney());
		System.out.println(user1.getBal());
	}

}
