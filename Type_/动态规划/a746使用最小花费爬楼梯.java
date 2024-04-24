package Type_.动态规划;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * ht<a href="tps://leetcode.cn/problems/min-cost-climbing-stairs/description/>746. 使用最小花费爬楼梯</a>
 */
public class a746使用最小花费爬楼梯 {
    class Solution {
        /**
         * 记忆化搜索
         * @param cost
         * @return
         */
        public int minCostClimbingStairs(int[] cost) {
            int n = cost.length;
            int[] memo = new int[n + 1];
            Arrays.fill(memo, -1);
            return dfs(n, memo, cost);
        }

        public int dfs(int n, int[] memo, int[] cost) {
            if (n <= 1)
                return 0;

            if (memo[n] != -1)
                return memo[n];

            int res1 = dfs(n - 1, memo, cost) + cost[n - 1];
            int res2 = dfs(n - 2, memo, cost) + cost[n - 2];

            return memo[n] = Math.min(res1, res2);

        }
    }


    class Solution1 {
        /**
         * 一维dp
         * @param cost
         * @return
         */
//        public int minCostClimbingStairs(int[] cost) {
//            int[] dp = new int[cost.length + 1];
//            dp[0] = 0;
//            dp[1] = 0;
//
//            for (int i = 2; i <= cost.length; i++) {
//                dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
//
//            }
//            return dp[cost.length];
//        }

        /**
         * 空间优化
         *
         * @param cost
         * @return
         */
        public int minCostClimbingStairs(int[] cost) {
            int f0 = 0, f1 = 0;
            //dp[i] 由 dp[i-1]和dp[i-2]转移而来,dp[i + 1] 由 dp[i]和dp[i-1]转移而来。
            //所以算出来dp[i]算出来之后,dp[i-2]就不需要了
            for (int i = 1; i < cost.length; i++) {
                int newF = Math.min(f1 + cost[i], f0 + cost[i - 1]);
                f0 = f1;
                f1 = newF;
            }
            return f1;
        }

    }
}
