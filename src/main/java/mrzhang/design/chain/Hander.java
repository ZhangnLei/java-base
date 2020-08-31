package mrzhang.design.chain;

import java.util.Map;

/**
 * @author zhangnianlei
 * @date 2020/8/30
 */
public abstract class Hander {
	
	protected Hander successor = null;

	public Hander getSuccessor() {
		return successor;
	}

	public void setSuccessor(Hander successor) {
		this.successor = successor;
	}
	
	public abstract Map<String, Object> handFeeRequest(Map<String, Object> param);
	
}
