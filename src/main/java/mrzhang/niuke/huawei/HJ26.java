package mrzhang.niuke.huawei;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zhangnianlei
 * @description
 *
 * 描述
 * 编写一个程序，将输入字符串中的字符按如下规则排序。
 *
 * 规则 1 ：英文字母从 A 到 Z 排列，不区分大小写。
 *
 * 如，输入： Type 输出： epTy
 *
 * 规则 2 ：同一个英文字母的大小写同时存在时，按照输入顺序排列。
 *
 * 如，输入： BabA 输出： aABb
 *
 * 规则 3 ：非英文字母的其它字符保持原来的位置。
 *
 *
 * 如，输入： By?e 输出： Be?y
 *
 *
 * 注意有多组测试数据，即输入有多行，每一行单独处理（换行符隔开的表示不同行）
 *
 *
 * 输入描述：
 * 输入字符串
 * 输出描述：
 * 输出字符串
 * 示例1
 * 输入：
 * A Famous Saying: Much Ado About Nothing (2012/8).
 * 复制
 * 输出：
 * A aaAAbc dFgghh: iimM nNn oooos Sttuuuy (2012/8).
 * @date 2021/8/5
 */
public class HJ26 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			System.out.println(popSort(line));
		}
	}


	/**
	 * @description
	 * @author zhangnianlei
	 * @date 2021/8/5
	 * @throws
	 * @param: line
	 * @return: java.lang.String
	 * @modifier
	 * @param line
	 */
	private static String popSort(String line) {

		// 1. 将所有的字母提取出来
		List<String> strList = new LinkedList<>();
		for (int i = 0; i < line.length() - 1; i++) {
			char now = line.charAt(i);
			if (Character.isLetter(now)) {
				strList.add(String.valueOf(now));
			}
		}

		// 2. 忽略大小写排序
		Queue<String> queue = new LinkedList<>();
		strList.stream().sorted(String::compareToIgnoreCase).forEach(each -> {
			queue.add(each);
		});

		// 3. 将字母覆盖
		String[] split = line.split("");
		for (int i = 0; i < split.length - 1; i++) {
			String now = split[i];
			if (is_alpha(now)) {
				split[i] = queue.poll();
			}
		}

		// 4. 返回
		StringBuilder sb = new StringBuilder();
		for (String c : split) {
			sb.append(c);
		}

		return sb.toString();
	}


	public static boolean is_alpha(String str) {
		if(str==null) return false;
		return str.matches("[a-zA-Z]+");
	}

}
