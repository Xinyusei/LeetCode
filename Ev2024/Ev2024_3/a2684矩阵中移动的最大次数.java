package Ev2024.Ev2024_3;

/**
 * 2684. 矩阵中移动的最大次数
 * https://leetcode.cn/problems/maximum-number-of-moves-in-a-grid/description/?envType=daily-question&envId=2024-03-16
 */
public class a2684矩阵中移动的最大次数 {
    public int maxMoves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        int res = 1;
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (dp[i][j - 1] != 0 && grid[i][j] > grid[i][j - 1])
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - 1] + 1);
                if (i > 0 && dp[i - 1][j - 1] != 0 && grid[i][j] > grid[i - 1][j - 1])
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                if (i + 1 < m && dp[i + 1][j - 1] != 0 && grid[i][j] > grid[i + 1][j - 1])
                    dp[i][j] = Math.max(dp[i][j], dp[i + 1][j - 1] + 1);
                if (dp[i][j] > res)
                    res = dp[i][j];
            }
        }
        return res == 1 ? 0 : res - 1;
    }
}
