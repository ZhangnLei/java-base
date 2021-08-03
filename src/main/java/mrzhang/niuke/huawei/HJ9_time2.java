package mrzhang.niuke.huawei;

import java.util.Scanner;

/**
 * @author zhangnianlei
 * @description
 * @date 2021/8/3
 */
public class HJ9_time2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String[] s = sc.nextLine().split("");
			StringBuilder sb = new StringBuilder();
			for (int i = s.length - 1; i >= 0; i--) {
				String each = s[i];
				if (sb.indexOf(each) <= -1) {
					sb.append(each);
				}
			}
			System.out.println(sb.toString());
		}
	}

}
