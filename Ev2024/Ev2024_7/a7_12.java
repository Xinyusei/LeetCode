package Ev2024.Ev2024_7;

import java.util.Arrays;

public class a7_12 {
    class Solution {
        public int[] numberGame(int[] nums) {
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i += 2) {
                int t = nums[i];
                nums[i] = nums[i + 1];
                nums[i + 1] = t;
            }
            return nums;
        }
    }
}
