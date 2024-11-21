package prob05;

public class Account {

	private String accountNo;
	private int balance;
	
	public Account(String accountNo) {
		this.accountNo = accountNo;
		this.balance = 0;
		
		System.out.println(accountNo + " 계좌가 개설 되었습니다.");
	}

	public String getAccountNo() {
		return accountNo;
	}

	public int getBalance() {
		return balance;
	}
	
	public void setBalance(int balance) {
		this.balance = balance;
	}

	public void save(int money) {
		balance += money;
		
		System.out.println(accountNo + " 계좌에 " + money + "만원이 입금 되었습니다.");
	}
	
	public void deposit(int money) {
		balance -= money;
		
		System.out.println(accountNo + " 계좌에 " + money + "만원이 출금 되었습니다.");
	}
	
}
