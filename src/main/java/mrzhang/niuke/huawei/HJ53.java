package mrzhang.niuke.huawei;

import java.util.Scanner;

/**
 * @author zhangnianlei
 * @description
 * @date 2021/8/2
 */
public class HJ53 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNextInt()) {
			int n = sc.nextInt();

			System.out.println(yangHui(n));
		}
	}


	private static int yangHui(int n) {

		if (n <= 2) return -1;
		if (n % 2 == 1) return 2;
		if (n % 4 == 0) return 3;
		return 4;
	}

}
