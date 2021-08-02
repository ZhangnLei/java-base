package mrzhang.niuke.huawei;

import java.util.Scanner;

/**
 * @author zhangnianlei
 * @description
 * @date 2021/8/3
 */
public class HJ20 {

	private static final String YES = "OK";

	private static final String NO = "NG";


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNextLine()) {

			String line = sc.nextLine();
			// 1.
			int length = line.length();
			if (length <= 8) {
				System.out.println(NO);
				continue;
			}

			// 2.
			int lowCase = 0;
			int upCase = 0;
			int num = 0;
			int other = 0;
			for (int i = 0; i < length; i++) {
				char c = line.charAt(i);
				if (Character.isLowerCase(c)) {
					lowCase = 1;
				} else if (Character.isDigit(c)) {
					num = 1;
				} else if (Character.isUpperCase(c)) {
					upCase = 1;
				} else {
					other = 1;
				}
			}

//			for (int i = 0; i < length; i++) {
//				char c = line.charAt(i);
//				if ('A' < c && c < 'Z') {
//					upCase = 1;
//				}
//			}

			int count = lowCase + num + upCase + other;
			if (count < 3) {
				System.out.println(NO);
				continue;
			}

			// 3.
			boolean sign = true;
			for (int i = 0; i < length - 5; i++) {
				for (int j = i + 3; j < length -2; j++) {
					if (line.charAt(i) == line.charAt(j) && line.charAt(i+1) == line.charAt(j+1) && line.charAt(i+2) == line.charAt(j+2)) {
						sign = false;
					}
				}

			}

			if (sign) {
				System.out.println(YES);
			} else {
				System.out.println(NO);
			}


		}
	}

}
