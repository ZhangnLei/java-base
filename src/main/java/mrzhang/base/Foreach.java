package mrzhang.base;

/**
 * @author zhangnianlei
 * @date 2020/4/19
 */
public class Foreach {
	public static void main(String[] args) {
		String[] name = { "zhangsan", "lisi", "wangwu" };
		for (String s : name) {
			if (s.equals("lisi")) {
				break;
			}
			System.out.println(s);
		}
	}
}
