package mrzhang.niuke.huawei;

import java.util.Scanner;

/**
 * @author zhangnianlei
 * @description
 * @date 2021/8/2
 */
public class HJ83 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {

			// 1.
			String[] line1 = sc.nextLine().split(" ");
			int m = Integer.valueOf(line1[0]);
			int n = Integer.valueOf(line1[1]);
			System.out.println(m > 9 || n > 9 ? -1 : 0);

			// 2.
			String[] line2 = sc.nextLine().split(" ");

			int x1 = Integer.valueOf(line2[0]);
			int y1 = Integer.valueOf(line2[1]);
			int x2 = Integer.valueOf(line2[2]);
			int y2 = Integer.valueOf(line2[3]);
			if (x1 > m-1 || x2 > m-1 || y1 > n-1 || y2 > n-1) {
				System.out.println(-1);
			} else {
				System.out.println(0);
			}

			// 3.
			String line3 = sc.nextLine();
			int i3 = Integer.valueOf(line3);
			if (i3 + 1 >= 9 || i3 > m) {
				System.out.println(-1);
			} else {
				System.out.println(0);
			}

			// 4.
			String line4 = sc.nextLine();
			int i4 = Integer.valueOf(line4);
			if (i4 + 1 >= 9 || i4 > n) {
				System.out.println(-1);
			} else {
				System.out.println(0);
			}

			// 5.
			String[] line5 = sc.nextLine().split(" ");
			int x = Integer.valueOf(line5[0]);
			int y = Integer.valueOf(line5[1]);

			if (x > m-1 || y > n-1) {
				System.out.println(-1);
			} else {
				System.out.println(0);
			}


		}
	}

}
