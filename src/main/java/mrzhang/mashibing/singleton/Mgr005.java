package mrzhang.mashibing.singleton;

/**
 * 单例 - hurry safe - use Double check lock (DCL)
 *
 * @author zhangnianlei
 * @date 2020/11/7
 */
public class Mgr005 {

	private static volatile Mgr005 INSTANCE;

	private Mgr005() {
	}

	public static Mgr005 getInstance() {
		if (null == INSTANCE) {
			synchronized (Mgr005.class) {
				if (null == INSTANCE) {
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					INSTANCE = new Mgr005();
				}
			}

		}
		return INSTANCE;
	}

	public void m () {
		System.out.println("m");
	}

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			new Thread(() -> {
				System.out.println(Mgr005.getInstance().hashCode());
			}).start();
		}
	}
}
