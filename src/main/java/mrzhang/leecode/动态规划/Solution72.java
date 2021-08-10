package mrzhang.leecode.动态规划;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangnianlei
 * @description 给你两个单词 word1 和 word2，
 * 请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 * <p>
 * 你可以对一个单词进行如下三种操作：
 * <p>
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/edit-distance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/8/9
 */
public class Solution72 {

	private static Map<String, Integer> resMap = new HashMap<>();
	/**
	 * @throws
	 * @description 请你计算出将 word1 转换成 word2 所使用的最少操作数
	 * @author zhangnianlei
	 * @date 2021/8/9
	 * @param: word1
	 * @param: word2
	 * @return: int
	 * @modifier
	 */
	public int minDistance1(String word1, String word2) {
		int i = word1.length();
		int j = word2.length();
		return dp1(word1, word2, i - 1, j - 1);
	}


	private int dp1(String word1, String word2, int i, int j) {
		String key = i + "," + j;
		if (resMap.containsKey(key)) {
			return resMap.get(key);
		}
		if (i == -1) return j + 1;
		if (j == -1) return i + 1;

		int res = 0;
		if (word1.charAt(i) == word2.charAt(j)) {
			res =  dp1(word1, word2, i - 1, j - 1);
		} else {
			res =  Math.min(dp1(word1, word2, i - 1, j), Math.min(dp1(word1, word2, i - 1, j - 1), dp1(word1, word2, i, j - 1))) + 1;
		}
		resMap.put(key, res);
		return res;

	}






}
