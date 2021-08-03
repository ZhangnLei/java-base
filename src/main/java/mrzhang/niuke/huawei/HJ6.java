package mrzhang.niuke.huawei;

import java.util.Scanner;

/**
 * @author zhangnianlei
 * @description
 * @date 2021/8/3
 */
public class HJ6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();

			StringBuilder sb = new StringBuilder();
			for (int i = 2; i <= Math.sqrt(n); i++) {
				if (n % i == 0) {
					sb.append(i).append(" ");
					n = n / i;
					i --;
				}
			}
			sb.append(n).append(" ");
			System.out.println(sb.toString());
		}
	}

}
