package mrzhang.niuke.huawei;

import sun.security.util.Length;

import java.util.Scanner;

/**
 * @author zhangnianlei
 * @description
 * 描述
 * 接受一个只包含小写字母的字符串，然后输出该字符串反转后的字符串。（字符串长度不超过1000）
 *
 * 输入描述：
 * 输入一行，为一个只包含小写字母的字符串。
 *
 * 输出描述：
 * 输出该字符串反转后的字符串。
 * @date 2021/8/2
 */
public class HJ12 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			String[] s = sc.nextLine().split("");
			int length = s.length;
			for (int i = length - 1; i >= length / 2; i--) {
				String tmp = s[i];
				s[i] = s[length - i - 1];
				s[length - i - 1] = tmp;
			}
			System.out.println(String.join("", s));

		}
	}


}
