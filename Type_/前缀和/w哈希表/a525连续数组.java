package Type_.前缀和.w哈希表;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: ZJX
 * @Date: 2024/09/24
 * @Description:
 */
public class a525连续数组 {
    class Solution1 {
        public int findMaxLength(int[] nums) {
            //0,0,1,0,1,1,0
            //0,0,0,1,1,2,3,3
            int n = nums.length;
            int[] s = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                s[i] = s[i - 1] + nums[i - 1];
            }
            // x 个 0 ， x 个 1 和为 x 长度为2x
            int ans = 0;
            HashMap<Integer, Integer> record = new HashMap<>();
            //record<k,v> k 表示 01数量差.
            record.put(0, 0);
            for (int i = 1; i <= n; i++) {
                Integer preIdx = record.getOrDefault(i - 2 * s[i], -1);
                if (preIdx != -1) {
                    ans = Math.max(ans, i - preIdx);
                } else
                    record.put(i - 2 * s[i], i);
            }
            return ans;
        }
    }

    class Solution2 {
        public int findMaxLength(int[] nums) {
            //0,0,1,0,1,1,0
            //-1,-1,1,-1,1,1,-1
            //0,-1,-2,-1,-2,-1,0,-1
            int n = nums.length;
            int[] s = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                s[i] = s[i - 1] + (nums[i - 1] == 0 ? -1 : 1);
            }
            // x 个 0 ， x 个 1 和为 x 长度为2x
            int ans = 0;
            System.out.println(Arrays.toString(s));
            HashMap<Integer, Integer> record = new HashMap<>();
            //record<k,v> k 表示 01数量差.
            record.put(0, 0);
            for (int i = 1; i <= n; i++) {
                int v = s[i];
                if (record.containsKey(v)) {
                    ans = Math.max(ans, i - record.get(v));
                } else
                    record.put(v, i);
            }
            return ans;
        }
    }
}
