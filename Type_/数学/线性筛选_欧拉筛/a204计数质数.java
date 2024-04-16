package Type_.数学.线性筛选_欧拉筛;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/count-primes/description/">计数质数</a>
 */
public class a204计数质数 {
    class Solution {
        int MX;
        boolean[] prime;

        public int countPrimes(int n) {
            if (n < 2)
                return 0;
            MX = n;
            prime = new boolean[MX];
            int ans = 0;

            Arrays.fill(prime, true);
            for (int i = 2; i * i < MX; i++) {
                if (prime[i]) {
                    ans++;
                    for (int j = i * i; j < MX; j += i)
                        prime[j] = false;
                }
            }
            return ans;
        }


        //判断是否是质数/素数
        //常规
        boolean isPrime(int n) {
            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0)
                    return false;
            }
            return true;
        }
    }
}
