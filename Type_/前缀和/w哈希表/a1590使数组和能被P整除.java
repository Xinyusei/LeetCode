package Type_.前缀和.w哈希表;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @Author: ZJX
 * @Date: 2024/09/24
 * @Description: <a href="https://leetcode.cn/problems/make-sum-divisible-by-p/description/">1590使数组和能被P整除</a>
 */
public class a1590使数组和能被P整除 {
    //(a+b)mod p=(a mod p+b mod p) mod p
    //例如 (16 + 26) mod 10=(16 mod 10 + 26 mod 10) mod 10=(6 + 6) mod 10 = 2


    //前置知识：处理取模的小技巧
    //如果 x 和 y 均为非负数，则 x≡ y(mod p) 相当于
    //
    //x mod p = y mod p
    //如果 x<0，y≥0，则 x≡y(modp) 相当于
    //
    //xmodp+p=ymodp
    //例如 −17mod10+10=−7+10=3。
    //为了避免判断 x 是否为负数，等号左边可以写成
    //(xmodp+p)modp
    //这样无论 x 是否为负数，最终都会落在区间 [0,p) 中。

    class Solution {
        public int minSubarray(int[] nums, int p) {
            //3,4,8,10
            //0,3,4,2,4
            //找到 去掉元素的和 mod p == sum mod p(m)
            int n = nums.length;
            int[] s = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                s[i] = (s[i - 1] + nums[i - 1]) % p;
            }
            int x = s[n];
            HashMap<Integer, Integer> record = new HashMap<>();
            //s[right]−s[left]≡x(modp)
            //s[right]−x≡s[left](modp)
            //例如 [11,2,5,7,8,9] 的前缀和 s=[0,11,13,18,25,33,42]，其中 25−13≡2(mod10)，25−2≡13(mod10)。
            //(s[right] mod p - x mod p + p) mod p = s[left] mod p
            //(s[right] mod p - m + p) mod p = s[left] mod p
            int ans = n;
            for (int i = 0; i <= n; i++) {
                int v = s[i];
                record.put(v, i);
                int j = record.getOrDefault((v - x + p) % p, -n);
                ans = Math.min(ans, i - j);
            }
            return ans == n ? -1 : ans;
        }
    }
}
