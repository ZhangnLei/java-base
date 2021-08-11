package mrzhang.leecode.动态规划;

/**
 * @author zhangnianlei
 * @description
 * @date 2021/8/10
 */
public class Solution72_time3 {


	public static void main(String[] args) {
		System.out.println("hello");
	}
	private int m;

	public int minDistance(String word1, String word2) {
		int m = word1.length();
		int n = word2.length();


		int[][] dp = new int[m+1][n+1];
		for (int i = 1; i <= m; i++) {
			dp[i][0] = i;
		}

		for (int j = 1; j <= n; j++) {
			dp[0][j] = j;
		}

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (word1.charAt(i-1) == word2.charAt(j-1)) {
					// 这里为什么要用word1.charAt(i-1) ？
					// 因为i有一个-1，但是数组没有下标-1，所有扩容了一位，dp table添加了 ""空字符串，
					// 故字符串中实际字母为 S1.chatAt(i-1)
					dp[i][j] = dp[i-1][j-1];
				} else {
					dp[i][j] = min (
							dp[i-1][j] + 1,
							dp[i][j-1] + 1,
							dp[i-1][j-1] + 1
					);
				}
			}
		}
		return dp[m][n];
	}


	private int min(int a, int b, int c) {
		return Math.min(a, Math.min(b, c));
	}

}
