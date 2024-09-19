package Type_.前缀和.w哈希表;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: ZJX
 * @Date: 2024/09/19
 * @Description: <a href="https://leetcode.cn/problems/binary-subarrays-with-sum/description/">930和相同的二元子数组</a>
 * 30分钟
 */
public class a930和相同的二元子数组 {
    class Solution {
        public int numSubarraysWithSum(int[] nums, int goal) {
            //0,1,1,2,2,3
            HashMap<Integer, Integer> map = new HashMap<>();
            //0,0,0,0,0,0
            for (int i = 1; i < nums.length; i++) {
                nums[i] += nums[i - 1];
            }
            map.put(0, 1);
            //1,1,2,2,3
            int res = 0;
            for (int num : nums) {
                int toFind = num - goal;
                res += map.getOrDefault(toFind, 0);
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            return res;
        }
    }
}
