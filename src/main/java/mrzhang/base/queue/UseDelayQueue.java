package mrzhang.base.queue;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;

/**
 * @author zhangnianlei
 * @date 2020/7/1
 */
public class UseDelayQueue {
	public static void main(String[] args) {
		DelayQueue delayQueue = new DelayQueue();

		Object a= "zhang";
		delayQueue.put((Delayed) a);
	}
}
