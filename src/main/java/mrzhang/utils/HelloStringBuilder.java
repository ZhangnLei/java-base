package mrzhang.utils;

/**
 * @author zhangnianlei
 * @date 2020/11/25
 */
public class HelloStringBuilder {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder("hello");

		sb.deleteCharAt(sb.length() - 1);
		System.out.println(sb.toString());


		StringBuilder sql = new StringBuilder("and ( zhangn = nian or ");
		String s = sql.substring(0, sql.length() - 4);
		System.out.println(s);

	}
}
