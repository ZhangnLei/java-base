package mrzhang.exception;

/**
 * @author zhangnianlei
 * @date 2020/5/4
 */
public class ExceptionInMethods {
	public static void main(String[] args) {
		try {
			dosomething();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void dosomething() throws Exception {
		try {
			Integer num = null;
			int i = 10 / num;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println();
			throw new Exception();
		}
	}
}
