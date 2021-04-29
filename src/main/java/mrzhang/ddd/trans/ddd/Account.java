package mrzhang.ddd.trans.ddd;

/**
 * @author zhangnianlei
 * @date 2021/3/25
 */
public class Account {
	private String id;
	private double balance;
	private OverdraftPolicy overdraftPolicy;
//  . . .
	public double balance() { return balance; }
	public void debit(double amount) {
		this.overdraftPolicy.preDebit(this, amount);
		this.balance = this.balance - amount;
		this.overdraftPolicy.postDebit(this, amount);
	}
	public void credit(double amount) {
		this.balance = this.balance + amount;
	}
}
