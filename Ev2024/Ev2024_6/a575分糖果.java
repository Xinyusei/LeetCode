package Ev2024.Ev2024_6;

import java.util.HashSet;
import java.util.Set;

/**
 * 575. 分糖果
 * https://leetcode.cn/problems/distribute-candies/description/?envType=daily-question&envId=2024-06-03
 */
public class a575分糖果 {
    class Solution {
        public int distributeCandies(int[] candyType) {
            int up = candyType.length >>> 1;
            Set<Integer> type = new HashSet<>();
            for (int candy : candyType) {
                type.add(candy);
            }
            return Math.min(up,type.size());
        }
    }
}
