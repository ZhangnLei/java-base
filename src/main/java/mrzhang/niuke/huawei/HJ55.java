package mrzhang.niuke.huawei;

import java.util.Scanner;

/**
 * @author zhangnianlei
 * @description
 * @date 2021/8/5
 */
public class HJ55 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			int n = Integer.parseInt(sc.nextLine());

			int count = 0;
			for (int i = 1; i <= n; i++) {
				String s = String.valueOf(i);
				if (i % 7 == 0) {
					count ++;
				} else if (s.indexOf("7") > -1) {
					count ++;
				}
			}
			System.out.println(count);
		}
	}

}
