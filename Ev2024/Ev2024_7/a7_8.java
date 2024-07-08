package Ev2024.Ev2024_7;

/**
 * <a href="https://leetcode.cn/problems/find-pivot-index/?envType=daily-question&envId=2024-07-08">724. 寻找数组的中心下标</a>
 */
public class a7_8 {
    class Solution {
        public int pivotIndex(int[] nums) {
            int s = 0, sl = 0;
            for (int num : nums) {
                s += num;
            }
            if ((s - nums[0]) == sl)
                return 0;
            for (int i = 1; i < nums.length; i++) {
                sl += nums[i - 1];
                if (sl == s - sl - nums[i])
                    return i;
            }
            return -1;
        }
    }
}
