package Type_.数学.线性筛选_欧拉筛;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 2521. 数组乘积中的不同质因数数目
 * <a href="https://leetcode.cn/problems/distinct-prime-factors-of-product-of-array/description/">...</a>
 */
public class a2521数组乘积中的不同质因数数目 {
    public int distinctPrimeFactors(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int MX = 1001;
        boolean[] prime = new boolean[MX];
        Arrays.fill(prime, true);
        for (int i = 2; i * i < MX; i++) {
            if (prime[i])
                for (int j = i * i; j * i < MX; j += i)
                    prime[j] = false;
        }
        for (int x : nums) {
            for (int i = 2; i * i <= x; i++) {
                if (prime[i] && (x % i == 0)) {
                    set.add(i);
                    while (x % i == 0)
                        x /= i;
                }
                if (x > 1)
                    set.add(x);
            }
        }
        return set.size();
    }
}
