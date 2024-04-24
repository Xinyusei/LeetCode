package Type_.动态规划;

/**
 * <a href="https://leetcode.cn/problems/count-ways-to-build-good-strings/description/">2466. 统计构造好字符串的方案数</a>
 */
public class a2466统计构造好字符串的方案数 {
    class Solution {
        final int MOD = (int) 1e9 + 7;

        public int countGoodStrings(int low, int high, int zero, int one) {
            int[] dp = new int[high + 1];
            dp[0] = 1;
            int res = 0;
            for (int i = 1; i <= high; i++) {
                if (i >= zero)
                    dp[i] = (dp[i] + dp[i - zero]) % MOD;
                if (i >= one)
                    dp[i] = (dp[i] + dp[i - one]) % MOD;
                if (i >= low)
                    dp[i] = (dp[i] + dp[i - low]) % MOD;
            }
            return dp[high];
        }
    }
}
