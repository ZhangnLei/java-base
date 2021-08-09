package mrzhang.niuke.huawei;

import java.util.Scanner;

/**
 * @author zhangnianlei
 * @description 描述
 * 输入两个用字符串表示的整数，求它们所表示的数之和。
 * 字符串的长度不超过10000。
 * 本题含有多组样例输入。
 * 输入描述：
 * 输入两个字符串。保证字符串只含有'0'~'9'字符
 * <p>
 * 输出描述：
 * 输出求和后的结果
 * <p>
 * 示例1
 * 输入：
 * y 1234
 * x   45
 * <p>
 * 翻转
 * x 54
 * y 54321
 * <p>
 * 输出：
 * 11111111100
 * @date 2021/8/5
 */
public class HJ57 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			String x = sc.nextLine();
			String y = sc.nextLine();
			System.out.println(plus(x, y));
		}
	}


	private static String plus(String x, String y) {

		// 保证x的len是小于等于y的长度
		if (x.length() > y.length()) {
			return plus(y, x);
		}

		boolean addOne = false;
		StringBuilder sb = new StringBuilder();

		// 翻转字符串
		x = reversalStr(x);
		y = reversalStr(y);

		for (int i = 0; i < x.length(); i++) {

			int a = Integer.valueOf(x.substring(i, i + 1));
			int b = Integer.valueOf(y.substring(i, i + 1));
			int sum = addOne ? a + b + 1 : a + b;
			if (sum > 9) {
				addOne = true;
				int res = sum % 10;
				sb.append(res);
			} else {
				addOne = false;
				sb.append(sum);
			}
		}
		int lenDiff = y.length() - x.length();
		if (lenDiff > 0) {
			String left = y.substring(x.length());
			String leftNum = reversalStr(left);
			if (addOne) leftNum = plus(leftNum, "1");
			return leftNum + sb.reverse().toString();
		} else {
			if (addOne) sb.append(1);
			return sb.reverse().toString();
		}
	}


	private static String reversalStr(String str) {
		return new StringBuilder(str).reverse().toString();
	}

}
