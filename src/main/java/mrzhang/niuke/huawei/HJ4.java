package mrzhang.niuke.huawei;

import java.util.Scanner;

/**
 * @author zhangnianlei
 * @description
 *
 * 描述
 * •连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组；
 * •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 *
 * 输入描述：
 * 连续输入字符串(输入多次,每个字符串长度小于100)
 *
 * 输出描述：
 * 输出到长度为8的新字符串数组
 *
 * 示例1
 * 输入：
 * abc
 * 123456789
 *
 * 输出：
 * abc00000
 * 12345678
 * 90000000
 *
 * @date 2021/8/4
 */
public class HJ4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			String str = sc.nextLine();
			int length = str.length();
			if (null == str || length == 0) break;

			// 1. 小于
			if (length < 8) {
				fixStr(str);
			} else if (length == 8) {
				// 2. 等于8
				System.out.println(str);
			} else {
				// 3. 大于8
				int i = 0;
				while (i <= length - 8) {
					String each = str.substring(i, i + 8);
					System.out.println(each);
					i += 8;
				}
				int leftNum = length % 8;
				fixStr(str.substring(length-leftNum, length));
			}
		}
	}


	private static void fixStr(String str) {
		int length = str.length();
		if (null == str || length == 0) return;
		StringBuilder sb = new StringBuilder();
		sb.append(str);

		for (int i = 0; i < 8 - length; i++) {
			sb.append("0");
		}
		System.out.println(sb.toString());
	}
}
