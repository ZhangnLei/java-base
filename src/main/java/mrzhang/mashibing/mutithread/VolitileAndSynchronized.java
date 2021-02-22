package mrzhang.mashibing.mutithread;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangnianlei
 * @description 用一个实验来验证volitile关键字与synchronize关键字的区别
 * @date 2020/11/21
 */
public class VolitileAndSynchronized {

	/**
	 * 实验过程：
	 * 1. 一个属性：count，初始值为0;
	 * 2. 一个方法：m() 将count++执行1w次
	 * 3. 创建10个线程，同事运行m()方法，看最后的结果是否为10w?
	 */

	int count = 0;

	synchronized void m() {
		for (int i = 0; i < 10000; i++) count ++;
	}

	public static void main(String[] args) {
		VolitileAndSynchronized t = new VolitileAndSynchronized();
		List<Thread> threads = new ArrayList<>(10);
		for (int i = 0; i < 10; i++) {
			threads.add(new Thread(t::m, "thread-"+ i));
		}

		threads.forEach(thread -> {
			thread.start();
		});

		threads.forEach(o -> {
			try {
				o.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});

		System.out.println(t.count);
	}

}
