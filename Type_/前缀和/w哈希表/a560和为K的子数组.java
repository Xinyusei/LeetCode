package Type_.前缀和.w哈希表;

import java.util.HashMap;

/**
 * @Author: ZJX
 * @Date: 2024/09/20
 * @Description: <a href="https://leetcode.cn/problems/subarray-sum-equals-k/">...</a>
 */
public class a560和为K的子数组 {
    class Solution {
        public int subarraySum(int[] nums, int k) {
            HashMap<Integer, Integer> map = new HashMap<>();
            int n = nums.length;
            for (int i = 1; i < n; i++) {
                nums[i] += nums[i - 1];
            }
            int res = 0;
            //1,2,3
            map.put(0, 1);
            for (int num : nums) {
                int toVal = num - k;
                res += map.getOrDefault(toVal, 0);
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            return res;
        }
    }
}
