package Ev2024.Ev2024_7;

/**
 * 2970. 统计移除递增子数组的数目 I
 * https://leetcode.cn/problems/count-the-number-of-incremovable-subarrays-i/description/
 */
public class a7_10 {
    class Solution {
        public int incremovableSubarrayCount(int[] nums) {
            int n = nums.length;
            int res = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i; j < n; j++) {
                    if (isIncreasing(nums, i, j)) {
                        res++;
                    }
                }
            }
            return res;
        }

        //l <= r
        public boolean isIncreasing(int[] nums, int l, int r) {
            //左侧如果有元素,需要单调递增 右侧如果有元素,需要单调递增
            for (int i = 1; i < l; i++) {
                if (nums[i - 1] >= nums[i])
                    return false;
            }
            for (int i = r + 1; i < nums.length; i++) {
                if (nums[i - 1] >= nums[i])
                    return false;
            }
            //如果 左侧、右侧都有元素
            return l - 1 < 0 || r + 1 >= nums.length || nums[l - 1] < nums[r + 1];
        }
    }
}
