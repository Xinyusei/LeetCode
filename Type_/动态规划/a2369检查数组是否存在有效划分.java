package Type_.动态规划;

/**
 * 2369. 检查数组是否存在有效划分
 * https://leetcode.cn/problems/check-if-there-is-a-valid-partition-for-the-array/description/
 */
public class a2369检查数组是否存在有效划分 {
    public boolean validPartition(int[] nums) {

        //动态规划 - 分解问题

        //要存在有效划分
        //1.最后两个数相等,且前n-2个数构成至少一个有效划分的数组
        //2.最后三个数相等/最后三个数递增,且前n-3个数构成至少一个有效划分的数组
        int n = nums.length;
        // dp[i] 表示前 i 个元素构成的数组是否至少存在一个有效划分
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        dp[1] = false;
        dp[2] = nums[0] == nums[1];
        // 0 1 2 3
        for (int i = 3; i <= n; i++) {
            if (dp[i - 2] && validTWO(nums[i - 2], nums[i - 1]))
                dp[i] = true;
            else if (dp[i - 3] && validThree(nums[i - 3], nums[i - 2], nums[i - 1])) {
                dp[i] = true;
            } else
                dp[i] = false;
        }

        return dp[n];


    }

    boolean validTWO(int num1, int num2) {
        return num1 == num2;
    }

    boolean validThree(int num1, int num2, int num3) {
        if (num1 == num2 && num1 == num3)
            return true;
        return num1 + 1 == num2 && num2 + 1 == num3;
    }
}
