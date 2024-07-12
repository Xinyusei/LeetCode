package lcRating.gt1400le1600;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/determine-whether-matrix-can-be-obtained-by-rotation/description/
 */
public class a1886判断矩阵经轮转后是否一致 {
    class Solution {
        public boolean findRotation(int[][] mat, int[][] target) {
            if (Arrays.deepEquals(mat, target)) {
                return true;
            }
            for (int i = 0; i < 3; i++) {
                mat = turn90(mat);
                if (Arrays.deepEquals(mat, target))
                    return true;
            }
            return false;
        }

        public int[][] turn90(int[][] nums) {

            int m = nums.length, n = nums[0].length;
            int[][] res = new int[m][n];
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < n; j++) {
                    res[j][n - 1 - i] = nums[i][j];
                }
            }
            return res;
        }
    }
}
