package mrzhang.ddd.trans;

/**
 * @author zhangnianlei
 * @date 2021/3/25
 */
public class DebitException extends RuntimeException {
	private static final long serialVersionUID = 1L;


	private String msg;
	private String code = "0002";

	public DebitException(String errorMsg) {
		this.msg = errorMsg;
	}
}
