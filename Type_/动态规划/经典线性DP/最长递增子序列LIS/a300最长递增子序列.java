package Type_.动态规划.经典线性DP.最长递增子序列LIS;

import java.util.Arrays;

/**
 * 300. 最长递增子序列
 * https://leetcode.cn/problems/longest-increasing-subsequence/description/
 * 2024-6-17
 */
public class a300最长递增子序列 {
    class Solution {
        public int lengthOfLIS(int[] nums) {
            int n = nums.length;
            int[] f = new int[n];
            //f[i] 表示以nums[0~i]的子序列且以nums[i]结尾的最长递增子序列的长度
            Arrays.fill(f, 1);
            int ret = 1;
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j])
                        f[i] = Math.max(f[i], f[j] + 1);
                }
                ret = Math.max(ret, f[i]);
            }
            System.out.println(Arrays.toString(f));
            return ret;
        }
    }
}
