package mrzhang.leecode.动态规划;

/**
 * @author zhangnianlei
 * @description
 * @date 2021/8/10
 */
public class Solution72_time2 {

	public int minDistance(String word1, String word2) {
		int m = word1.length();
		int n = word2.length();
		int[][] dp = new int[m+1][n+1];

		for (int i = 1; i <= m; i++) {
			dp[i][0] = i;
		}

		for (int j = 0; j < n; j++) {
			dp[0][j] = j;
		}

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (word1.charAt(i) == word2.charAt(j)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = min(
							dp[i - 1][j] + 1,
							dp[i][j - 1] + 1,
							dp[i - 1][j - 1] + 1
					);
				}
			}
		}
		return dp[m][n];

	}


	private static int min(int a, int b, int c) {
		return Math.min(a, Math.min(b, c));
	}

}
