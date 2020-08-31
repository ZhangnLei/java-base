package mrzhang.design.chain;

import java.util.Map;

/**
 * @author zhangnianlei
 * @date 2020/8/31
 */
public class ImportHander extends Hander {
	@Override
	public Map<String, Object> handFeeRequest(Map<String, Object> param) {
		System.out.println("导入数据");
		if (getSuccessor() != null) {
			return getSuccessor().handFeeRequest(param);
		}
		return null;
	}
}
