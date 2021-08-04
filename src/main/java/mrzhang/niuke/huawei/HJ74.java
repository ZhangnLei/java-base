package mrzhang.niuke.huawei;

import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhangnianlei
 * @description
 * @date 2021/8/4
 */
public class HJ74 {

	public static void main1(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			String command = sc.nextLine();

			if (command.indexOf("\"") <= -1) {
				// 没有双引号
				String[] s = command.split(" ");
				System.out.println(s.length);
				for (String each : s) {
					System.out.println(each);
				}

			} else {
				int size = 0;
				List<String> list = new ArrayList<>();

				for (int i = 0; i < command.length(); i++) {
					StringBuilder sb = new StringBuilder();
					if ('"' == command.charAt(i)) {
						i++;
						while (i < command.length() && '"' != command.charAt(i)) {
							sb.append(command.charAt(i));
							i++;
						}
						if (i < command.length() - 1) {
							i++;
						}
					} else if (' ' == command.charAt(i)) {
						if (i < command.length() - 1) {
							i++;
							while (i < command.length() && ' ' != command.charAt(i)) {
								sb.append(command.charAt(i));
								i++;
							}
						}
					} else {

						while (i < command.length() && ' ' != command.charAt(i)) {
							sb.append(command.charAt(i));
							i++;
						}
					}
					list.add(sb.toString());

				}

				System.out.println(list.size());
				for (String each : list) {
					System.out.println(each);
				}
			}
		}
	}


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			String command = sc.nextLine();
			String[] s = command.split(" ");

			if (command.indexOf("\"") <= -1) {
				System.out.println(s.length);
				for (String s1 : s) {
					System.out.println(s1);
				}
			} else {
				int flag = 0;
				StringBuilder sb = new StringBuilder();
				List<String> list = new ArrayList<>();
				for (int i = 0; i < s.length; i++) {
					flag += countFlag(s[i]);
					if (flag % 2 ==0 ) {
						if (sb.length() != 0) {
							sb.append(" ");
						}
						sb.append(s[i]);
						list.add(sb.toString());
						sb =  new StringBuilder();
					} else {
						if (sb.length() != 0) {
							sb.append(" ");
						}
						sb.append(s[i]);
					}
				}
				System.out.println(list.size());
				list.forEach(each -> {
					System.out.println(each.replaceAll("\"", ""));
				});
			}
		}
	}


	/**
	 * @description 计算字符串中引号的个数
	 * @author zhangnianlei
	 * @date 2021/8/4
	 * @throws
	 * @param: str
	 * @return: int
	 * @modifier
	 */
	public static int countFlag(String str) {
		if (null == str || str.length() == 0) return 0;
		int flag = 0;
		for (int i = 0; i < str.length(); i++) {
			if ('"' == str.charAt(i)) {
				flag ++;
			}
		}
		return flag;
	}
}
