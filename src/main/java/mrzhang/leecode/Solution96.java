package mrzhang.leecode;

import java.lang.reflect.Array;

/**
 * @author zhangnianlei
 * @date 2020/7/16
 *
 * 96. 不同的二叉搜索树
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 *
 * 示例:
 *
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 */
public class Solution96 {


	/**
	 * @description
	 * 思路：G(n)为n个节点组成二叉搜索树的个数，f(i)为以i为根节点二叉搜索树的个数
	 * 则有：G(n) = f(1) + f(2) + ... + f(n);
	 * 又因为i的左侧有i-1个节点，右侧有n-i个节点，
	 * 则有：f(i) = G(i-1) * G(n-i);
	 * 结合上述两式则有
	 * G(n) = G(0) * G(n-1) + G(1) * G(n-2) + ... + G(n-1) * G(0);
	 *
	 * @author zhangnianlei
	 * @date 2020/7/16
	 * @exception
	 * @param: n
	 * @return: int
	 * @modifier
	 */
	public static int numTrees(int num) {
		int dp[] = new int[num+1];
		dp[0] = 1;
		dp[1] = 1;
		for (int n = 2; n <= num; n++) {
			for (int i = 1; i <= n; i ++) {
				dp[n] += dp[i-1] * dp[n-i];
			}
		}
		return dp[num];
	}

	public static int numTrees1(int n) {
		int[] dp = new int[n+1];
		dp[0] = 1;
		dp[1] = 1;

		for(int i = 2; i < n + 1; i++)
			for(int j = 1; j < i + 1; j++)
				dp[i] += dp[j-1] * dp[i-j];

		return dp[n];
	}

	public static int g(int n) {
		if (n == 0) return 1;
		if (n == 1) return 1;
		int res = 0;
		int i = 1;
		while(i <= n) {
			res += f(i, n);
			i ++;
		}
		return res;
	}

	public static int f(int i, int n) {
		if (i == 1) return 1;
		return g(i - 1) * g(n - i);
	}

	public static void main(String[] args) {
		System.out.println(numTrees1(3));
	}
}
