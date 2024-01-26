package lcRating.gt1200le1400;

/**
 * 2319. 判断矩阵是否是一个 X 矩阵
 * https://leetcode.cn/problems/check-if-matrix-is-x-matrix/
 * rank1201
 */
public class a2319判断矩阵是否是一个x矩阵 {
    public boolean checkXMatrix(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j || i + j == n - 1) {
                    if (grid[i][j] == 0)
                        return false;
                } else {
                    if (grid[i][j] != 0)
                        return false;
                }
            }
        }
        return true;
    }
}
