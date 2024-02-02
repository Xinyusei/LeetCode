package Ev2024.Ev2024_1;

/**
 * https://leetcode.cn/problems/longest-alternating-subarray/?envType=daily-question&envId=2024-01-23
 * 2765. 最长交替子数组
 */

public class a1_23ez {
    public int alternatingSubarray(int[] nums) {
        int ans = -1;
        for (int i = 0; i < nums.length; i++) {
            int base = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int diff = j - i, add = 0;
                if (diff % 2 != 0) {
                    add = 1;
                }
                if (base + add == nums[j]) {
                    ans = Math.max(ans, j - i + 1);
                }
                else
                    break;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        a1_23ez test = new a1_23ez();
        System.out.println(test.alternatingSubarray(new int[]{2, 3, 4, 3, 4}));
    }
}
