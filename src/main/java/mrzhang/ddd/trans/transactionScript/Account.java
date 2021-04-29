package mrzhang.ddd.trans.transactionScript;

import lombok.Data;

/**
 * @author zhangnianlei
 * @date 2021/3/25
 */
@Data
public class Account {
	// @Id
	private String id;
	private double balance;
	private int overdraftPolicy;

}
