package mrzhang.ddd.trans.transactionScript;

import mrzhang.ddd.trans.DebitException;

import static netscape.security.Privilege.ALLOWED;
import static sun.net.InetAddressCachePolicy.NEVER;

/**
 * @author zhangnianlei
 * @date 2021/3/25
 */
public class MoneyTransferServiceTransactionScriptImpl implements MoneyTransferService {

	private AccountDao accountDao;
	private BankingTransactionRepository bankingTransactionRepository;
//  . . .
	@Override
	public BankingTransaction transfer(
			String fromAccountId, String toAccountId, double amount) {
		Account fromAccount = accountDao.findById(fromAccountId);
		Account toAccount = accountDao.findById(toAccountId);
//    . . .
		double newBalance = fromAccount.getBalance() - amount;
		switch (fromAccount.getOverdraftPolicy()) {
			case NEVER:
				if (newBalance < 0) {
					throw new DebitException("Insufficient funds");
				}
				break;
			case ALLOWED:
				double limit = 100;
				if (newBalance < -limit) {
					throw new DebitException("Overdraft limit (of " + limit + ") exceeded: " + newBalance);
				}
				break;
		}
		fromAccount.setBalance(newBalance);
		toAccount.setBalance(toAccount.getBalance() + amount);
		BankingTransaction moneyTransferTransaction =
				new MoneyTranferTransaction(fromAccountId, toAccountId, amount);
		bankingTransactionRepository.addTransaction(moneyTransferTransaction);
		return moneyTransferTransaction;
	}
}
