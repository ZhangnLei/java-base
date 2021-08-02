package mrzhang.niuke.huawei;

import java.util.Scanner;

/**
 * @author zhangnianlei
 * @description
 * @date 2021/8/2
 */
public class HJ9 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNextLine()) {
			String[] s = sc.nextLine().split("");
			StringBuilder sb = new StringBuilder();
			for (int i = s.length - 1; i >= 0; i--) {
				if (sb.indexOf(s[i]) <= -1) {
					sb.append(s[i]);
				}
			}
			System.out.println(sb.toString());
		}
	}
}
