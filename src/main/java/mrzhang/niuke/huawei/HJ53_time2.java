package mrzhang.niuke.huawei;

import java.util.Scanner;

/**
 * @author zhangnianlei
 * @description
 * @date 2021/8/3
 */
public class HJ53_time2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNext()) {
			int n = sc.nextInt();
			if (n <= 2) {
				System.out.println(-1);
			} else if (n % 2 == 1) {
				System.out.println(2);
			}else if (n % 4 ==0)  {
				System.out.println(3);
			} else {
				System.out.println(4);
			}
		}
	}

}
