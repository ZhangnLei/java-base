package mrzhang.niuke.inputOutput;

import java.util.Scanner;

/**
 * @author zhangnianlei
 * @description
 * 链接：https://ac.nowcoder.com/acm/contest/5657/G
 * 来源：牛客网
 *
 * 输入数据有多组, 每行表示一组输入数据。
 *
 * 每行不定有n个整数，空格隔开。(1 <= n <= 100)。
 * @date 2021/8/2
 */
public class Main7 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (scanner.hasNextLine()) {
			String lineTxt = scanner.nextLine();
			String[] strList = lineTxt.split(" ");
			int sum = 0;
			for (String s : strList) {
				sum += Integer.valueOf(s);
			}
			System.out.println(sum);
		}
	}
}
