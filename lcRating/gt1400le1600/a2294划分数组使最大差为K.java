package lcRating.gt1400le1600;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/partition-array-such-that-maximum-difference-is-k/description/">2294. 划分数组使最大差为 K</a>
 *
 * @Author: ZJX
 * @Date: 2024/08/07
 * @Description: 1416分
 */
public class a2294划分数组使最大差为K {
    class Solution {
        public int partitionArray(int[] nums, int k) {
            Arrays.sort(nums);
            //1,2,3,5,6
            int lo = 0, hi = 0;
            int res = 0;
            while (hi < nums.length) {
                int minVal = nums[lo];
                int maxVal = minVal + k;
                while (hi < nums.length && nums[hi] <= maxVal)
                    hi++;
                res++;
                lo = hi;
            }
            return res;
        }
    }
}
