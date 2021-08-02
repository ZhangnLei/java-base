package mrzhang.ddd.trans.ddd;

/**
 * @author zhangnianlei
 * @date 2021/3/25
 */
public interface OverdraftPolicy {
	void preDebit(Account account, double amount);
	void postDebit(Account account, double amount);

}
