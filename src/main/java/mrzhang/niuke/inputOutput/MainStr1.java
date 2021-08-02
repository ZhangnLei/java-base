package mrzhang.niuke.inputOutput;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author zhangnianlei
 * @description
 * 链接：https://ac.nowcoder.com/acm/contest/5657/H
 * 来源：牛客网
 *
 * 输入描述:
 * 输入有两行，第一行n
 *
 * 第二行是n个空格隔开的字符串
 * 输出描述:
 * 输出一行排序后的字符串，空格隔开，无结尾空格
 *
 * 示例1
 * 输入
 * 5
 * c d a bb e
 * 输出
 * a bb c d e
 *
 * @date 2021/8/2
 */
public class MainStr1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (scanner.hasNextLine()) {
			Integer count = Integer.valueOf(scanner.nextLine());
			String[] strList = scanner.nextLine().split(" ");
			Arrays.sort(strList);

			String join = String.join(" ", strList);
			System.out.println(join);
		}
	}

}
