package lcRating.gt1400le1600;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 2834. 找出美丽数组的最小和
 * https://leetcode.cn/problems/find-the-minimum-possible-sum-of-a-beautiful-array/description/
 */
public class a2834找出美丽数组的最小和 {
    class Solution {
        static int MOD = (int) 1e9 + 7;

        public int minimumPossibleSum(int n, int target) {
            long m = Math.min(target / 2, n);

            return (int) (((m + 1) * m + (2 * target + n - m - 1) * (n - m)) / 2 % MOD);
        }
    }
}
