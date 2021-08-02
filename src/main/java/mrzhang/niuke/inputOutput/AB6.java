package mrzhang.niuke.inputOutput;

import java.util.Scanner;

/**
 * @author zhangnianlei
 * @description
 * 链接：https://ac.nowcoder.com/acm/contest/5657/F
 * 来源：牛客网
 *
 * 输入数据有多组, 每行表示一组输入数据。
 * 每行的第一个整数为整数的个数n(1 <= n <= 100)。
 * 接下来n个正整数, 即需要求和的每个正整数。
 *
 * @date 2021/8/2
 */
public class AB6 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int count = scanner.nextInt();
			int sum = 0;
			for (int i = 0; i < count; i++) {
				sum += scanner.nextInt();
			}
			System.out.println(sum);
		}
	}
}
