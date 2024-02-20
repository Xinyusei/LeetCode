package lcRating.gt1400le1600;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.cn/problems/maximum-number-of-coins-you-can-get/
 */
public class a1561可以获得的最大硬币数目 {
    public int maxCoins(int[] piles) {

        //1 2 2 4 7 8
        //1 2 3 4 5 6 7 8 9
        Arrays.sort(piles);
        int sum = 0, n = piles.length;
        for (int i = n - 2; i >= n / 3; i -= 2) {
            sum += piles[i];
        }
        return sum;
    }
}
