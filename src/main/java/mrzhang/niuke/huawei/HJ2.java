package mrzhang.niuke.huawei;

import java.util.Scanner;

/**
 * @author zhangnianlei
 * @description
 * @date 2021/8/4
 */
public class HJ2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			String line = sc.nextLine().toLowerCase();
			String word = sc.nextLine().toLowerCase();

			char w = word.charAt(0);

			int  count = 0;
			for (int i = 0; i < line.length(); i++) {
				if (w == line.charAt(i)) {
					count ++;
				}

			}
			System.out.println(count);
		}
	}
}
