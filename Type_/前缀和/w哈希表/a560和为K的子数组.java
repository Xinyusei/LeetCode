package Type_.前缀和.w哈希表;

import java.util.HashMap;
import java.util.Map;

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


class a1524和为奇数的子数组数目 {
    class Solution {
        private final static int MOD = (int) 1e9 + 7;

        public int numOfSubarrays(int[] arr) {
            //0,1,4,9
            long even = 0, odd = 0, res = 0;
            int n = arr.length;
            if ((arr[0] & 1) == 0)
                even++;
            else {
                odd++;
                res++;
            }
            for (int i = 1; i < n; i++) {
                arr[i] += arr[i - 1];
                //本身是偶数,
                if ((arr[i] & 1) == 0) {
                    res = (res + odd) % MOD;
                    even++;
                } else {
                    res = (even + 1 + res) % MOD;
                    odd++;
                }
            }
            return (int) res;
        }
    }
}


/**
 * 同余性质
 */
class a974和可被K整除的子数组 {
    /**
     * 时间复杂度:0(n²) - 此时哈希表记录的是nums[i]
     */
    class Solution1 {
        public int subarraysDivByK(int[] nums, int k) {
            int n = nums.length;
            //4,9,9,7,4,5
            for (int i = 1; i < n; i++) {
                nums[i] += nums[i - 1];
            }
            int res = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);
            for (int cur : nums) {
                for (Integer c : map.keySet()) {
                    if ((cur - c) % k == 0)
                        res += map.get(c);
                }
                map.put(cur, map.getOrDefault(cur, 0) + 1);
            }
            return res;
        }
    }

    class Solution2 {
        public int subarraysDivByK(int[] nums, int k) {

            //4,9,9,7,4,5
            int sum = 0, ans = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            //维护一个以前缀和模k的值为键,出现次数为值的哈希表
            map.put(0, 1);
            //map[0]=1，这样就考虑了前缀和本身被 k 整除的情况。
            for (int e : nums) {
                sum += e;
                //4,4,4,2,4,0
                //Java 取模 特殊性,当被除数为负数的时候取模结果为负,需要纠正
                int mod = (sum % k + k) % k;
                int same = map.getOrDefault(mod, 0);
                ans += same;
                map.put(mod, same + 1);
            }
            return ans;
        }
    }

    class Solution3 {
        public int subarraysDivByK(int[] nums, int k) {

            //4,9,9,7,4,5
            int sum = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);
            for (int e : nums) {
                sum += e;
                //Java 取模 特殊性,当被除数为负数的时候取模结果为负,需要纠正
                int mod = (sum % k + k) % k;
                map.put(mod, map.getOrDefault(mod, 0) + 1);
            }
            //4,4,4,2,4,0
            //4:4, 2:1, 0:1
            int ans = 0;
            for (Map.Entry<Integer, Integer> e : map.entrySet()) {
                ans += e.getValue() * (e.getValue() - 1) / 2;
            }
            return ans;
        }
    }
}

