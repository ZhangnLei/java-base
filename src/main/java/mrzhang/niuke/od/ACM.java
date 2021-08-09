package mrzhang.niuke.od;

import java.util.Scanner;

/**
 * @author zhangnianlei
 * @description
 * @date 2021/8/5
 */
public class ACM {


	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			String[] s = sc.nextLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			System.out.println(a + b);
		}
	}

}
