package mrzhang.niuke.huawei;

import java.util.Scanner;

/**
 * @author zhangnianlei
 * @description 描述
 * Catcher是MCA国的情报员，他工作时发现敌国会用一些对称的密码进行通信，比如像这些ABBA，ABA，A，123321，但是他们有时会在开始或结束时加入一些无关的字符以防止别国破解。比如进行下列变化 ABBA->12ABBA,ABA->ABAKK,123321->51233214　。因为截获的串太长了，而且存在多种可能的情况（abaaab可看作是aba,或baaab的加密形式），Cathcer的工作量实在是太大了，他只能向电脑高手求助，你能帮Catcher找出最长的有效密码串吗？
 * <p>
 * 本题含有多组样例输入。
 * <p>
 * 输入描述：
 * 输入一个字符串
 * <p>
 * 输出描述：
 * 返回有效密码串的最大长度
 * <p>
 * 示例1
 * 输入：
 * ABBA
 * 复制
 * 输出：
 * 4
 * 复制
 * @date 2021/8/5
 */
public class HJ32_timeout {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			String word = sc.nextLine();
			int length = word.length();
			int total = 1;
			for (int i = 0; i < length - 1; i++) {
				for (int j = i + 1; j < length; j++) {
					String each = word.substring(i, j + 1);
					if (isHuiWen(each) && total < each.length()) {
						total = each.length();
					}
				}
			}
			System.out.println(total);
		}
	}


	private static boolean isHuiWen(String each) {

		for (int i = 0; i < each.length() / 2; i++) {
			if (each.charAt(i) != each.charAt(each.length() - i - 1)) {
				return false;
			}
		}
		return true;
	}

}
