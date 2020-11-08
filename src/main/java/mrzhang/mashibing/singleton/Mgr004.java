package mrzhang.mashibing.singleton;

/**
 * 单例 - hurry safe - use synchronized on method
 *
 * @author zhangnianlei
 * @date 2020/11/7
 */
public class Mgr004 {

	private static Mgr004 INSTANCE;

	private Mgr004() {
	}

	public static synchronized Mgr004 getInstance() {
		if (null == INSTANCE) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			INSTANCE = new Mgr004();
		}
		return INSTANCE;
	}

	public void m () {
		System.out.println("m");
	}

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			new Thread(() -> {
				System.out.println(Mgr004.getInstance().hashCode());
			}).start();
		}
	}
}
