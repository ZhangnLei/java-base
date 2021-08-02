package mrzhang.niuke.huawei;

import java.util.Scanner;

/**
 * @author zhangnianlei
 * @description
 * @date 2021/8/2
 */
public class HJ61 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextInt()) {
			System.out.println(putApple(sc.nextInt(), sc.nextInt()));
		}
	}


	private static int putApple(int m, int n) {
		if (m == 0) return 1;
		if (m == 1 || n == 1) return 1;
		if (n > m) return putApple(m, m);
		return putApple(m, n - 1) + putApple(m - n, n);
	}

}
