package mrzhang.niuke.huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author zhangnianlei
 * @description
 * @date 2021/8/3
 */
public class HJ88 {

	private static Map<String, Integer> cardMap = new HashMap<>(15);
	static {
		cardMap.put("3", 0);
		cardMap.put("4", 1);
		cardMap.put("5", 2);
		cardMap.put("6", 3);
		cardMap.put("7", 4);
		cardMap.put("8", 5);
		cardMap.put("9", 6);
		cardMap.put("10", 7);
		cardMap.put("J", 8);
		cardMap.put("Q", 9);
		cardMap.put("K", 10);
		cardMap.put("A", 11);
		cardMap.put("2", 12);
		cardMap.put("joker", 13);
		cardMap.put("JOKER", 14);
	}

	private static final String TWO_JOKER1 = "joker JOKER";
	private static final String TWO_JOKER2 = "JOKER joker";
	private static final String ERROR = "ERROR";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String[] s = sc.nextLine().split("-");
			String one = s[0];
			String two = s[1];

			System.out.println(compareCard(one, two));


		}
	}


	private static String compareCard(String one, String two) {

		if (TWO_JOKER1.equals(one) || TWO_JOKER2.equals(one)) {
			return one;
		}
		if (TWO_JOKER1.equals(two) || TWO_JOKER2.equals(two)) {
			return two;
		}

		String[] s1 = one.split(" ");
		String[] s2 = two.split(" ");

		if (s1.length == s2.length) {
			if (cardMap.get(s1[0]) > cardMap.get(s2[0])) {
				return one;
			} else {
				return two;
			}
		} else {
			if (s1.length == 4) {
				return one;
			} else if (s2.length == 4) {
				return two;
			} else {
				return ERROR;
			}
		}
	}

}
