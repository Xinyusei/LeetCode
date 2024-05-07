package Type_.动态规划.记忆化搜索;

import java.util.Arrays;

/**
 * 1463. 摘樱桃 II
 * https://leetcode.cn/problems/cherry-pickup-ii/description/?envType=daily-question&envId=2024-05-07
 */
public class a1463摘樱桃II {
    class Solution {
        public int cherryPickup(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            int[][][] memo = new int[m][n][n];
            for (int[][] me : memo) {
                for (int[] r : me) {
                    Arrays.fill(r, -1);
                }
            }
            return dfs(0, 0, n - 1, grid, memo);
        }

        private int dfs(int i, int j, int k, int[][] grid, int[][][] memo) {
            int m = grid.length;
            int n = grid[0].length;
            if (i == m || j < 0 || j >= n || k < 0 || k >= n)
                return 0;
            if (memo[i][j][k] != -1)
                return memo[i][j][k];
            int res = 0;
            for (int j2 = j - 1; j2 <= j + 1; j2++) {
                for (int k2 = k - 1; k2 <= k + 1; k2++) {
                    res = Math.max(res, dfs(i + 1, j2, k2, grid, memo));
                }
            }
            res += grid[i][j] + (k != j ? grid[i][k] : 0);
            return memo[i][j][k] = res;
        }
    }
}
