package mrzhang.niuke.huawei;

import java.util.Scanner;

/**
 * @author zhangnianlei
 * @description
 * @date 2021/8/2
 */
public class HJ3702 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextInt()) {
			int m = sc.nextInt();
			System.out.println(count(m));
		}
	}


	private static int count(int m) {
		int a = 1, b = 1, res = 1;
		for (int i = 2; i < m; i++) {
			res = a + b;
			a = b;
			b = res;

		}

		return res;
	}

}
