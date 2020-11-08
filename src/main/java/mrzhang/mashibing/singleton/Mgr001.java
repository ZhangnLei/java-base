package mrzhang.mashibing.singleton;

/**
 * 最简单的单例 - 懒汉式
 * @author zhangnianlei
 * @date 2020/11/7
 */
public class Mgr001 {

	private static final Mgr001 INSTANCE = new Mgr001();

	private Mgr001() {
	}

	public static Mgr001 getInstance() {
		return INSTANCE;
	}

	public void m() {
		System.out.println("m");
	}

	public static void main(String[] args) {
		Mgr001 m1 = Mgr001.getInstance();
		Mgr001 m2 = Mgr001.getInstance();
		System.out.println(m1 == m2);
	}
}
