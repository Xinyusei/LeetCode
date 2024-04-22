package Type_.动态规划;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/climbing-stairs/description/">70. 爬楼梯</a>
 */
public class a70爬楼梯 {
    class Solution1 {
        public int climbStairs(int n) {
            int[] memo = new int[n + 1];
            int[] nums = new int[]{1, 2};
            Arrays.fill(memo, -1);
            return dfs(n, memo, nums);
        }

        public int dfs(int stairs, int[] memo, int[] nums) {
            if (stairs == 0)
                return 1;
            if (memo[stairs] != -1)
                return memo[stairs];
            int res = 0;
            for (int num : nums) {
                if (stairs >= num)
                    res += dfs(stairs - num, memo, nums);
            }
            return memo[stairs] = res;
        }
    }

    class S2 {
        public int climbStairs(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 1;

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= 2; j++) {
                    if (i >= j)
                        dp[i] += dp[i - j];
                }
            }
            return dp[n];
        }
    }
}
