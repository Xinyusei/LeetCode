package lcRating.gt1400le1600;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/number-of-smooth-descent-periods-of-a-stock/description/
 */
public class a2110股票平滑下跌阶段的数目 {
    class Solution {
        public long getDescentPeriods(int[] prices) {
            int n = prices.length;
            long[] f = new long[n];
            //base case
            long res = 1;
            f[0] = 1;
            for (int i = 1; i < prices.length; i++) {
                f[i] = f[i - 1];
                if (prices[i] - prices[i - 1] == -1)
                    f[i] += f[i - 1];
                res += f[i];
            }
            return res;

        }
    }
}
