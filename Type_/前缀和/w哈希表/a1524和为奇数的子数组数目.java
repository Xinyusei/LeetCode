package Type_.前缀和.w哈希表;

/**
 * @Author: ZJX
 * @Date: 2024/09/20
 * @Description:
 */
public class a1524和为奇数的子数组数目 {
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
