package 周赛.w393;

public class w393_100265素数的最大距离 {
    class Solution {
        boolean[] not_prime;
        int Max = 101;

        public int maximumPrimeDifference(int[] nums) {
            not_prime = new boolean[Max];
            not_prime[1] = true;
            for (int i = 2; i * i < Max; i++) {
                for (int j = i * i; j < Max; j += i) {
                    not_prime[j] = true;
                }
            }
            int lo = 0, hi = nums.length - 1;
            while (not_prime[nums[lo]])
                lo++;
            while (not_prime[nums[hi]])
                hi--;
            return hi - lo;
        }
    }
}
