package mrzhang.design.chain;

import com.sun.xml.internal.ws.developer.ValidationErrorHandler;

/**
 * @author zhangnianlei
 * @date 2020/8/31
 */
public class Client {

	public static void main(String[] args) {
		Hander h1 = new ImportHander();
		Hander h2 = new VerifyBusinessLogicHander();
		Hander h3 = new CheckHander();
		
		h3.setSuccessor(h2);
		h2.setSuccessor(h1);
		
		h3.handFeeRequest(null);
	}
}
