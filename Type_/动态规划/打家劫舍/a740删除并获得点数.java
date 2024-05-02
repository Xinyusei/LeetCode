package Type_.动态规划.打家劫舍;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 740. 删除并获得点数
 * https://leetcode.cn/problems/delete-and-earn/description/
 */
public class a740删除并获得点数 {
    class Solution {
        public int deleteAndEarn(int[] nums) {
            int maxVal = 0;
            for (int num : nums)
                maxVal = Math.max(maxVal, num);
            int[] sum = new int[maxVal + 1];
            for (int num : nums)
                sum[num] += num;
            //0 0 4 9 4
            int[] dp = new int[sum.length + 1];
            dp[0] = sum[0];
            dp[1] = Math.max(sum[0], sum[1]);
            for (int i = 2; i < sum.length; i++) {
                dp[i] = Math.max(dp[i - 2] + sum[i], dp[i - 1]);
            }
            return dp[sum.length - 1];
        }
    }
}
