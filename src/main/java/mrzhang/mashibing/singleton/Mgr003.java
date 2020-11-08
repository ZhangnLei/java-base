package mrzhang.mashibing.singleton;

/**
 * 单例 - hurry unsafe - use synchronized code block
 *
 * @author zhangnianlei
 * @date 2020/11/7
 */
public class Mgr003 {

	private static Mgr003 INSTANCE;

	private Mgr003() {
	}

	public static Mgr003 getInstance() {
		if (null == INSTANCE) {
			synchronized (Mgr003.class) {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				INSTANCE = new Mgr003();
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
				System.out.println(Mgr003.getInstance().hashCode());
			}).start();
		}
	}
}
