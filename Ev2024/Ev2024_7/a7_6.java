package Ev2024.Ev2024_7;

import java.util.Arrays;

/**
 * h<a href="ttps://leetcode.cn/problems/count-alternating-subarrays/description/?envType=daily-question&envId=2024-07-06
 * ">3101. 交替子数组计数</a>
 */
public class a7_6 {
    class Solution {
        public long countAlternatingSubarrays(int[] nums) {
            int n = nums.length;
            int[] f = new int[n];
            //f[i]表示以在nums[0~i]且以i为结尾的交替子数组的个数
            f[0] = 1;
            long res = 1;
            for (int i = 1; i < n; i++) {
                if (nums[i - 1] == nums[i])
                    f[i] = 1;
                else
                    f[i] = f[i - 1] + 1;
                res += f[i];
            }
            System.out.println(Arrays.toString(f));
            return res;
        }
    }
}
