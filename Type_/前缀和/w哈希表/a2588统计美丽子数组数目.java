package Type_.前缀和.w哈希表;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author: ZJX
 * @Date: 2024/09/23
 * @Description:
 */
public class a2588统计美丽子数组数目 {
    //前置知识：前缀异或和
    //下文中 ⊕ 表示异或运算
    //对于数组 nums，定义它的前缀异或和 s[0]=0，s[1]=s[0] ⊕ nums[0] = 0 ⊕ nums[0],s[2] = s[1] ⊕ nums[1]

    //3,1,2
    //111
    //001
    //010
    //3 ⊕ 1 = 2
    //2 ⊕ 2 = 0
    class Solution {
        public long beautifulSubarrays(int[] nums) {
            int n = nums.length;
            HashMap<Integer, Integer> record = new HashMap<>();
            int[] s = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                s[i] = s[i - 1] ^ nums[i - 1];
            }
            long ans = 0;
            for (int j : s) {
                //System.out.println(Arrays.toString(nums));
                ans += record.getOrDefault(j, 0);
                record.put(j, record.getOrDefault(j, 0) + 1);
            }
            return ans;
        }
    }
}
