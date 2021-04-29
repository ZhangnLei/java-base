package mrzhang.ddd.trans.ddd;

import mrzhang.ddd.trans.DebitException;

/**
 * @author zhangnianlei
 * @date 2021/3/25
 */
public class LimitedOverdraft {
	private double limit;
//  . . .
	public void preDebit(Account account, double amount) {
		double newBalance = account.balance() - amount;
		if (newBalance < -limit) {
			throw new DebitException(
					"Overdraft limit (of " + limit + ") exceeded: " + newBalance);
		}
	}
	public void postDebit(Account account, double amount) {
	}
}
