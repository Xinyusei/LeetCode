package Ev2024.Ev2024_6;

/**
 * 2928. 给小朋友们分糖果 I
 * https://leetcode.cn/problems/distribute-candies-among-children-i/description/?envType=daily-question&envId=2024-06-03
 */
public class a2928给小朋友们分糖果I {
    class Solution {
        public int distributeCandies(int n, int limit) {
            int ret = 0;
            for (int i = 0; i <= limit; i++) {
                for (int j = 0; j <= limit; j++) {
                    if (i + j > n)
                        break;
                    if (n - i - j <= limit)
                        ret++;
                }
            }
            return ret;
        }
    }
}
