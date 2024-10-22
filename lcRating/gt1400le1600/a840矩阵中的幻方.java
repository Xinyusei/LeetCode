package lcRating.gt1400le1600;

/**
 * @Author: ZJX
 * @Date: 2024/10/21
 * @Description:
 */
public class a840矩阵中的幻方 {
    class Solution {
        public int numMagicSquaresInside(int[][] grid) {
            int row = grid.length, col = grid[0].length;
            int ret = 0;
            for (int i = 0; i + 2 < row; i++) {
                for (int j = 0; j + 2 < col; j++) {
                    if (isValid(i, j, grid))
                        ret++;
                }
            }
            return ret;
        }

        public boolean isValid(int x, int y, int[][] grid) {
            //每行:
            int[] record = new int[10];
            for (int i = x ; i < x + 3; i++) {
                for (int j = y; j < y + 3; j++) {
                    if (grid[i][j] <= 0 || grid[i][j] >= 10)
                        return false;
                    if (record[grid[i][j]] == 1)
                        return false;
                    record[grid[i][j]] = 1;
                }
            }
            int rowSum = grid[x][y] + grid[x][y + 1] + grid[x][y + 2];
            for (int i = x + 1; i < x + 3; i++) {
                int curRowSum = 0;
                for (int j = y; j < y + 3; j++) {
                    curRowSum += grid[i][j];
                }
                if (rowSum != curRowSum)
                    return false;
            }
            int colSum = grid[x][y] + grid[x + 1][y] + grid[x + 2][y];
            for (int j = y + 1; j <= y + 2; j++) {
                int curColSum = 0;
                for (int i = x; i < x + 3; i++) {
                    curColSum += grid[i][j];
                }
                if (colSum != curColSum)
                    return false;
            }
            return grid[x][y] + grid[x + 2][y + 2] == grid[x + 2][y] + grid[x][y + 2];
        }
    }
}
