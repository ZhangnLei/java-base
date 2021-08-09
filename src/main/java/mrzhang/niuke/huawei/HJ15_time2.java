package mrzhang.niuke.huawei;

import java.util.Scanner;

/**
 * @author zhangnianlei
 * @description
 * @date 2021/8/5
 */
public class HJ15_time2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			int n = Integer.parseInt(sc.nextLine());
			String string = Integer.toBinaryString(n);
			int count = 0;
			for (int i = 0; i < string.length(); i++) {
				if ('1' == string.charAt(i)) {
					count++;
				}
			}
			System.out.println(count);
		}
	}

}
