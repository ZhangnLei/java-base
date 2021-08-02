package mrzhang.ddd.trans.ddd;


/**
 * @author zhangnianlei
 * @date 2021/3/25
 */
public class MoneyTransferServiceDomainModelImpl implements MoneyTransferService{
	private AccountRepository accountRepository;
	private BankingTransactionRepository bankingTransactionRepository;
//  . . .
	@Override
	public BankingTransaction transfer(String fromAccountId, String toAccountId, double amount) {
		Account fromAccount = accountRepository.findById(fromAccountId);
		Account toAccount = accountRepository.findById(toAccountId);
//    . . .
		fromAccount.debit(amount);
		toAccount.credit(amount);
		BankingTransaction moneyTransferTransaction =
				new MoneyTranferTransaction(fromAccountId, toAccountId, amount);
		bankingTransactionRepository.addTransaction(moneyTransferTransaction);
		return moneyTransferTransaction;
	}
}
