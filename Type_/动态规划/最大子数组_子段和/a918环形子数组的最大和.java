package Type_.动态规划.最大子数组_子段和;

/**
 * https://leetcode.cn/problems/maximum-sum-circular-subarray/description/
 */
public class a918环形子数组的最大和 {
    class Solution {
        public int maxSubarraySumCircular(int[] nums) {
            int n = nums.length;
            //1 -2 3 -2 1 -2 3 -2
            int[] dp1 = new int[n], dp2 = new int[n];
            int ans1 = dp1[0] = nums[0];
            int ans2 = dp2[0] = nums[0];
            int sum = ans1;
            for (int i = 1; i < n; i++) {
                dp1[i] = Math.max(dp1[i - 1], 0) + nums[i];
                ans1 = Math.max(dp1[i], ans1);
                dp2[i] = Math.min(dp2[i - 1], 0) + nums[i];
                ans2 = Math.max(dp2[i], ans2);
                sum += nums[i];
            }
            if (sum == ans2)
                return ans1;
            return Math.max(ans1, sum - ans2);
        }
    }
}
