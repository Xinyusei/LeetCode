package Type_.动态规划;

/**
 * 931. 下降路径最小和
 * https://leetcode.cn/problems/minimum-falling-path-sum/
 */
public class a931下降路径最小和 {

    /**
     * 
     * @param matrix
     * @return
     */
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        //base case
        System.arraycopy(matrix[0], 0, dp[0], 0, n);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int cur;
                if (j == 0)
                    cur = Math.min(dp[i - 1][j], dp[i - 1][j + 1]);
                else if (j == n - 1)
                    cur = Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
                else
                    cur = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i - 1][j + 1]));
                dp[i][j] = cur + matrix[i][j];
            }
        }
        //debug
        /*
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        */
        int res = dp[n - 1][0];
        for (int i : dp[n - 1]) {
            if (res > i)
                res = i;
        }
        return res;

    }
}
