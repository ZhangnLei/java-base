package mrzhang.niuke.inputOutput;

import java.util.Scanner;

/**
 * @author zhangnianlei
 * @description
 * @date 2021/8/2
 */
public class APlusB {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (scanner.hasNext()) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			System.out.println(a + b);
		}
	}
}
