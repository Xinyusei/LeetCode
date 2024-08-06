package Ev2024.Ev2024_8;

/**
 * https://leetcode.cn/problems/max-increase-to-keep-city-skyline/description/?envType=daily-question&envId=2024-08-06
 *
 * @Author: ZJX
 * @Date: 2024/08/06
 * @Description:
 */
public class a807保持城市天际线 {
    class Solution {
        public int maxIncreaseKeepingSkyline(int[][] grid) {
            int n = grid.length;
            int[] maxRow = new int[n];
            int[] maxCol = new int[n];
            int res = 0;
            for (int i = 0; i < n; i++) {
                int mR = grid[i][0];
                for (int j = 0; j < n; j++) {
                    mR = Math.max(mR, grid[i][j]);
                }
                maxRow[i] = mR;
            }
            for (int j = 0; j < n; j++) {
                int mC = grid[0][j];
                for (int i = 0; i < n; i++) {
                    mC = Math.max(mC, grid[i][j]);
                }
                maxCol[j] = mC;
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    res += Math.min(maxRow[i], maxCol[j]) - grid[i][j];
                }
            }
            return res;
        }
    }
}
