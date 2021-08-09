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

	/**
	 * @throws
	 * @description
	 * 暴力解采用双指针从两侧向中心搜索，复杂度可达O（n^3）。这里我们采用中心扩散的做法，把复杂度降到O（n^2）。
	 * 所谓中心扩散，就是选定一个值，然后向左右扩散。
	 * 我们可以发现，回文串有两种，一种是aabb，中心在ab之间；另一种是aacbb，中心为c。
	 * 我们可以写一个方法，通过给left和right传入不同的初始index来实现这两种情况。
	 * @author zhangnianlei
	 * @date 2021/8/5
	 * @param: args
	 * @modifier
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			String words = sc.nextLine();
			int max = 0;
			for (int i = 0; i < words.length() - 1; i++) {

				max = Math.max(max, getMaxStringLen(words, i, i));
				max = Math.max(max, getMaxStringLen(words, i, i + 1));
			}
			System.out.println(max);
		}

	}


	/**
	 * @throws
	 * @description 从 l-r 起点 为中心，寻找最大回文子串长度
	 * @author zhangnianlei
	 * @date 2021/8/5
	 * @param: words
	 * @param: l
	 * @param: r
	 * @return: int
	 * @modifier
	 */
	private static int getMaxStringLen(String words, int l, int r) {
		int max = 0;
		while (l >= 0 && r < words.length() && words.charAt(l) == words.charAt(r)) {
			int len = r - l + 1;
			max = Math.max(len, max);
			l--;
			r++;
		}
		return max;
	}

}
