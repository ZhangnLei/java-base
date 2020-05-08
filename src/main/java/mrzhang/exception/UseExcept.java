package mrzhang.exception;

/**
 * @author zhangnianlei
 * @date 2020/5/2
 */
public class UseExcept {

	public static void main(String[] args) {
		try {
			int i = 10/0;
			System.out.println("i="+i);
		} catch (ArithmeticException e) {
			System.out.println("Caught Exception");
			System.out.println("e.getMessage(): " + e.getMessage());
			System.out.println("e.toString(): " + e.toString());
			System.out.println("e.printStackTrace():");
			e.printStackTrace();
		} finally {
			System.out.println("run finally");
		}
	}

}
