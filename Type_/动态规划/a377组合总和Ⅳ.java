package Type_.动态规划;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/combination-sum-iv/description/?envType=daily-question&envId=2024-04-22"> * 377. 组合总和 Ⅳ</a>
 */
public class a377组合总和Ⅳ {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        int target = 3;
        System.out.println(new a377组合总和Ⅳ().combinationSum4(nums, target));
    }

    public int combinationSum4(int[] nums, int target) {
        int[] memo = new int[target + 1];
        Arrays.fill(memo, -1);
        dfs(target, memo, nums);
        return memo[target];
    }

    public int dfs(int target, int[] memo, int[] nums) {
        if (target == 0)
            return 1;

        if (memo[target] != -1)
            return memo[target];

        int res = 0;
        for (int x : nums) {
            if (x <= target)
                res += dfs(target - x, memo, nums);
        }
        memo[target] = res;
        return res;
    }

    /**
     * 记忆化搜索 - 自顶
     */
    class Solution1 {
        public int combinationSum4(int[] nums, int target) {
            int[] memo = new int[target + 1];
            Arrays.fill(memo, -1);
            dfs(target, memo, nums);
            return memo[target];
        }

        public int dfs(int target, int[] memo, int[] nums) {
            if (target == 0)
                return 1;

            if (memo[target] != -1)
                return memo[target];

            int res = 0;
            for (int x : nums) {
                if (x <= target)
                    res += dfs(target - x, memo, nums);
            }
            memo[target] = res;
            return res;
        }
    }

    /**
     * DP
     */
    class Solution2 {
        public int combinationSum4(int[] nums, int target) {
            int[] dp = new int[target + 1];
            dp[0] = 1;

            for (int i = 1; i <= target; i++) {
                for (int num : nums) {
                    if (i >= num)
                        dp[i] += dp[i - num];
                }
            }
            return dp[target];
        }
    }
}

