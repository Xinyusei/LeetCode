package 周赛.w392;

import java.util.Arrays;

public class w392_100264最长的严格递增或递减子数组 {
    class Solution {
        public int longestMonotonicSubarray(int[] nums) {
            int n = nums.length;
            int[] dpInc = new int[n];
            int[] dpDec = new int[n];

            Arrays.fill(dpInc, 1);
            Arrays.fill(dpDec, 1);

            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > nums[i - 1])
                    dpInc[i] = dpInc[i - 1] + 1;
                else if (nums[i] < nums[i - 1])
                    dpDec[i] = dpDec[i - 1] + 1;
            }
            int res = 1;
            for (int i = 0; i < dpInc.length; i++) {
                res = Math.max(res, Math.max(dpInc[i], dpDec[i]));
            }
            return res;
        }
    }
}


