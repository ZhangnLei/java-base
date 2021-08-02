package mrzhang.niuke.inputOutput;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author zhangnianlei
 * @description
 * @date 2021/8/2
 */
public class MainStr3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextLine()) {
			String[] split = scanner.nextLine().split(",");
			Arrays.sort(split);
			System.out.println(String.join(",", split));
		}
	}

}
