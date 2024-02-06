package Type_.动态规划;

import java.util.Arrays;

public class a53最大子数组和 {
    /**
     * 最长子数组-一维dp
     * @param nums
     * @return
     */
    /*
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        //dp[i]表示以nums[i]结尾的最大子数组和
        int[] dp = new int[n];
        //base case
        dp[0] = nums[0];
        int res = dp[0];
        //nums[i]唯有两种选择,与nums[i - 1]结合/单独成为一个
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            if (res < dp[i])
                res = dp[i];
        }
        return res;
    }
    */

    /**
     * 空间优化版本
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {

        int n = nums.length;
        //dp[i]表示以nums[i]结尾的最大子数组和
        int dp = nums[0];
        //base case
        int res = dp;
//        dp[i]有两种「选择」，要么与前面的相邻子数组连接，形成一个和更大的子数组；
//        要么不与前面的子数组连接，自成一派，自己作为一个子数组。
        for (int i = 1; i < n; i++) {
            dp = Math.max(dp + nums[i], nums[i]);
            if (res < dp)
                res = dp;
        }
        return res;
    }
}
