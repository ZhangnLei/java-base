package mrzhang.niuke.huawei;

import org.w3c.dom.ls.LSException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author zhangnianlei
 * @description 描述
 * 输入一个字符串，返回其最长的数字子串，以及其长度。若有多个最长的数字子串，则将它们全部输出（按原字符串的相对位置）
 * 本题含有多组样例输入。
 * <p>
 * 输入描述：
 * 输入一个字符串。
 * <p>
 * 输出描述：
 * 输出字符串中最长的数字字符串和它的长度，中间用逗号间隔。如果有相同长度的串，则要一块儿输出（中间不要输出空格）。
 * <p>
 * 示例1
 * 输入：
 * abcd12345ed125ss123058789
 * a8a72a6a5yy98y65ee1r2
 * 输出：
 * 123058789,9
 * 729865,2
 * @date 2021/8/3
 */
public class HJ92 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			System.out.println(getEldestSon(line));
		}
	}


	/**
	 * @throws
	 * @description 获取最长数字子串
	 * @author zhangnianlei
	 * @date 2021/8/3
	 * @param: str
	 * @return: java.lang.String
	 * @modifier
	 */
	private static String getEldestSon(String str) {
		List<StrSon> list = new ArrayList<>();
		int maxSize = 0;
		for (int i = 0; i < str.length(); i++) {
			if (Character.isDigit(str.charAt(i))) {
				int start = i;
				int end = i;
				while (i < str.length() - 1) {
					i++;
					if (Character.isDigit(str.charAt(i))) {
						end = i;
					} else {
						break;
					}
				}
				int size = end - start + 1;
				list.add(new StrSon(size, start, str.substring(start, end + 1)));
				maxSize = size > maxSize ? size : maxSize;
			}
		}


		int finalMaxSize = maxSize;
		List<StrSon> resultList = list.stream().sorted(
				Comparator.comparing((StrSon each) -> each.size).thenComparing((StrSon each) -> each.start))
				.filter(each -> each.size == finalMaxSize).collect(Collectors.toList());


		StringBuilder sb = new StringBuilder();
		for (StrSon each : resultList) {
			sb.append(each.str);
		}
		sb.append(",").append(resultList.get(0).size);
		return sb.toString();

	}


	public static class StrSon {

		int size;

		int start;

		String str;


		public StrSon(int size, int start, String str) {
			this.size = size;
			this.start = start;
			this.str = str;
		}

	}

}
