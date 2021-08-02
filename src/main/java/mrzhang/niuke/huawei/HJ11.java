package mrzhang.niuke.huawei;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhangnianlei
 * @description
 * @date 2021/8/2
 */
public class HJ11 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNext()) {
			String s = sc.nextLine();
			System.out.println(new StringBuilder(s).reverse().toString());
		}
	}

}
