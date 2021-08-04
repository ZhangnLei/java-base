package mrzhang.niuke.huawei;

import java.util.Scanner;

/**
 * @author zhangnianlei
 * @description
 * @date 2021/8/4
 */
public class HJ1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			String[] words = sc.nextLine().split(" ");
			String word = words[words.length - 1];
			System.out.println(word.length());
		}
	}
}
