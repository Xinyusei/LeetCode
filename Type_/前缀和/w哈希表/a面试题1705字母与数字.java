package Type_.前缀和.w哈希表;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author: ZJX
 * @Date: 2024/09/24
 * @Description: <a href="https://leetcode.cn/problems/make-sum-divisible-by-p/description/">1590使数组和能被P整除</a>
 * 依然是利用同余性质
 *
 */
public class a面试题1705字母与数字 {
    class Solution {
        public String[] findLongestSubarray(String[] array) {
            int n = array.length;
            int[] s = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                s[i] = s[i - 1] + (convert(array[i - 1]));
            }
            int ansIdx = 0;
            int ansLength = 0;
            System.out.println(Arrays.toString(s));
            HashMap<Integer, Integer> record = new HashMap<>();
            //record<k,v> k 表示 01数量差.
            record.put(0, 0);
            for (int i = 1; i <= n; i++) {
                int v = s[i];
                if (record.containsKey(v)) {
                    int firstIdx = record.get(v);
                    if (i - firstIdx > ansLength) {
                        ansLength = i - firstIdx;
                        ansIdx = firstIdx;
                    }
                } else
                    record.put(v, i);
            }
            //return Arrays.copyOfRange(array, ansIdx, ansLength - ansIdx, String[].class);
            String[] ans = new String[ansLength];
            System.arraycopy(array, ansIdx, ans, 0, ansLength);
            return ans;
        }

        private int convert(String s) {
            if (Character.isLetter(s.charAt(0))) {
                return 1;
            } else
                return -1;
        }
    }
}
