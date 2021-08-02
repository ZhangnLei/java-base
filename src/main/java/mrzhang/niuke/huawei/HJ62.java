package mrzhang.niuke.huawei;

import java.util.Scanner;

/**
 * @author zhangnianlei
 * @description
 * @date 2021/8/2
 */
public class HJ62 {

	public static void main1(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			String[] s = Integer.toBinaryString(n).split("");
			int count = 0;
			for (String each : s) {
				if ("1".equals(each)) {
					count++;
				}
			}
			System.out.println(count);

		}
	}


	public static void main2(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNext()) {
			int n = sc.nextInt();
			int count = 0;
			while (n > 0) {
				count++;
				n = n & (n - 1);
			}
			System.out.println(count);
		}
	}


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			int result = 0;
			while (n != 0) {
				if (n % 2 == 1) result++;
				n = (n - n % 2) / 2;
			}
			System.out.println(result);
		}
	}

}
