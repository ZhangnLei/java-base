package mrzhang.niuke.huawei;

import java.util.Scanner;

/**
 * @author zhangnianlei
 * @description
 * @date 2021/8/3
 */
public class Hj61_time2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			String[] s = sc.nextLine().split(" ");
			int m = Integer.valueOf(s[0]);
			int n = Integer.valueOf(s[1]);

			System.out.println(putApple(m, n));
		}
	}


	private static int putApple(int m, int n) {

		if (m <= 1) return 1;
		if (n == 1) return 1;
		/**
		 * 1 所有的盘子上至少有一个苹果
		 * 2 有一个盘子上没有苹果
		 * 情况1 + 情况2
		 */

		if (n > m) return putApple(m, m);
		return putApple(m, n-1) + putApple(m-n, n) ;
	}

}
