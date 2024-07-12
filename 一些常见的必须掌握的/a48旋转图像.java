package 一些常见的必须掌握的;

/**
 * <a href="https://leetcode.cn/problems/rotate-image/description/">...</a>
 */
public class a48旋转图像 {
    class Solution {
        public void rotate(int[][] matrix) {
            int n = matrix.length;
            int[][] t = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    t[j][n - 1 - i] = matrix[i][j];
                }
            }
            for (int i = 0; i < n; i++) {
                System.arraycopy(t[i], 0, matrix[i], 0, n);
            }
        }
    }
}
