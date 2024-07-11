package lcRating.gt1400le1600;

/**
 * https://leetcode.cn/problems/matrix-similarity-after-cyclic-shifts/description/
 */
public class a2946循环移位后的矩阵相似检查 {
    class Solution {
        public boolean areSimilar(int[][] mat, int k) {
            int m = mat.length, n = mat[0].length;
            k %= n;
            for (int i = 0; i < m; i++) {
                //奇数行
                if ((i & 1) != 0) {
                    for (int j = 0; j < n; j++) {
                        if (mat[i][j] != mat[i][(j + k) % n])
                            return false;
                    }
                    //
                } else {
                    //偶数行
                    for (int j = 0; j < n; j++) {
                        if (mat[i][j] != mat[i][(j - k + n) % n])
                            return false;
                    }
                }
            }
            return true;
        }
    }
}
