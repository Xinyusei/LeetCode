package Type_.数学.质数相关;

import java.util.Arrays;

/**
 * 3115. 质数的最大距离
 * https://leetcode.cn/problems/maximum-prime-difference/description/?envType=daily-question&envId=2024-07-02
 */
public class a3115质数的最大距离 {
    class Solution {
        private int MX;

        private boolean[] prime;
        public int maximumPrimeDifference(int[] nums) {
            //初始化
            countPrime(101);
            int lo = 0,hi = nums.length - 1;
            for(;lo < nums.length;lo++)
                if(prime[nums[lo]])
                    break;
            for(;hi >= 0;hi--)
                if(prime[nums[hi]])
                    break;
            return hi - lo;
        }

        private void countPrime(int mx){
            MX = mx;
            prime = new boolean[MX];
            Arrays.fill(prime,true);
            prime[0] = prime[1] = false;
            for(int i = 2;i * i <= MX;i ++){
                if(prime[i]){
                    for(int j = i * i;j <= MX ;j += i)
                        prime[j] = false;
                }
            }
        }
    }
}
