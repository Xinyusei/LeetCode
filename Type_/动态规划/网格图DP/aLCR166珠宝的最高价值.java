package Type_.动态规划.网格图DP;


/**
 * https://leetcode.cn/problems/li-wu-de-zui-da-jie-zhi-lcof/description/
 */
public class aLCR166珠宝的最高价值 {
    class Solution {
        public int jewelleryValue(int[][] frame) {
            int m = frame.length, n = frame[0].length;
            int[][] dp = new int[m][n];
            dp[0][0] = frame[0][0];
            for (int i = 1; i < m; i++)
                dp[i][0] = dp[i - 1][0] + frame[i][0];
            for (int j = 1; j < n; j++)
                dp[0][j] = dp[0][j - 1] + frame[0][j];
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + frame[i][j];
                }
            }
            return dp[m - 1][n - 1];
        }
    }
}
