package mrzhang.design.chain;

import java.util.Map;

/**
 * @author zhangnianlei
 * @date 2020/8/31
 */
public class VerifyBusinessLogicHander extends Hander {
	@Override
	public Map<String, Object> handFeeRequest(Map<String, Object> param) {
		System.out.println("检查业务逻辑");
		if (getSuccessor() != null) {
			return getSuccessor().handFeeRequest(param);
		}
		return null;
	}
}
