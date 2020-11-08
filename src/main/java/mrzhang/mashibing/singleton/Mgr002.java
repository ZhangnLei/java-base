package mrzhang.mashibing.singleton;

/**
 * 单例 - hurry unsafe
 * @author zhangnianlei
 * @date 2020/11/7
 */
public class Mgr002 {

	private static Mgr002 INSTANCE;

	private Mgr002 () {
	}

	public static Mgr002 getInstance() {
		if (null == INSTANCE) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			INSTANCE = new Mgr002();
		}
		return INSTANCE;
	}

	public void m () {
		System.out.println("m");
	}

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			new Thread(() -> {
				System.out.println(Mgr002.getInstance().hashCode());
			}).start();
		}
	}
}
