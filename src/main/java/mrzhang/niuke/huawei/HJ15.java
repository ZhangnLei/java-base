package mrzhang.niuke.huawei;

import java.util.Scanner;

/**
 * @author zhangnianlei
 * @description
 * @date 2021/8/2
 */
public class HJ15 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			String[] split = Integer.toBinaryString(n).split("");

			int sum = 0;
			for (String s : split) {
				System.out.println(s);
				if ("1".equals(s)) {
					sum += 1;
				}
			}
			System.out.println(sum);
		}
	}
}
