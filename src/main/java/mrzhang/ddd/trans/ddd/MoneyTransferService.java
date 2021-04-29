package mrzhang.ddd.trans.ddd;

/**
 * @author zhangnianlei
 * @date 2021/3/25
 */
public interface MoneyTransferService {
	BankingTransaction transfer(String fromAccountId, String toAccountId, double amount);
}
