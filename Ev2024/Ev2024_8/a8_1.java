package Ev2024.Ev2024_8;

import java.util.Arrays;

/**
 * 3011. 判断一个数组是否可以变为有序
 * <a href="https://leetcode.cn/problems/find-if-array-can-be-sorted/description/?envType=daily-question&envId=2024-08-06">...</a>
 *
 * @Author: ZJX
 * @Date: 2024/08/06
 * @Description:
 */
public class a8_1 {
    class Solution {
        public boolean canSortArray(int[] nums) {
            int[] cnt = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                cnt[i] = getSetBit(nums[i]);
            }
            //1,1,1,4,4
            int lo = 0, hi = 1;
            while (hi < cnt.length) {
                while (hi < cnt.length && cnt[hi - 1] == cnt[hi])
                    hi++;
                if (lo < hi - 1)
                    Arrays.sort(nums, lo, hi);
                lo = hi;
                hi++;
            }
            //System.out.println(Arrays.toString(nums));
            for (int i = 0; i + 1 < nums.length; i++) {
                if (nums[i] < nums[i + 1])
                    continue;
                return false;
            }
            return true;
        }

        public int getSetBit(int num) {
            int ans = 0;
            for (int i = 0; i <= 8; i++) {
                if ((num & 1) == 1)
                    ans++;
                num >>= 1;
            }
            return ans;
        }
    }
}
