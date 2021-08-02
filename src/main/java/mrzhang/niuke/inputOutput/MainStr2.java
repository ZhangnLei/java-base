package mrzhang.niuke.inputOutput;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author zhangnianlei
 * @description
 * @date 2021/8/2
 */
public class MainStr2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (scanner.hasNextLine()) {
			String[] s = scanner.nextLine().split(" ");
			Arrays.sort(s);
			System.out.println(String.join(" ", s));
		}
	}

}
