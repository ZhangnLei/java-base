package mrzhang.ddd.trans.ddd;

import mrzhang.ddd.trans.DebitException;

/**
 * @author zhangnianlei
 * @date 2021/3/25
 */
public class NoOverdraftAllowed implements OverdraftPolicy{
	public void preDebit(Account account, double amount) {
		double newBalance = account.balance() - amount;
		if (newBalance < 0) {
			throw new DebitException("Insufficient funds");
		}
	}
	public void postDebit(Account account, double amount) {
	}
}
