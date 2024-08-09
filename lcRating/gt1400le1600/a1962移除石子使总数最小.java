package lcRating.gt1400le1600;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.cn/problems/remove-stones-to-minimize-the-total/description/">1962移除石子使总数最小</a>
 *
 * @Author: ZJX
 * @Date: 2024/08/09
 * @Description: 1418 用时:
 */
public class a1962移除石子使总数最小 {
    class Solution {
        public int minStoneSum(int[] piles, int k) {
            int res = 0;
            PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
            for (int pile : piles) {
                queue.add(pile);
                res += pile;
            }
            for (int i = 0; i < k; i++) {
                Integer poll = queue.poll();
                int cut = (poll >> 1);
                res -= cut;
                queue.add(poll - cut);
            }
            return res;
        }
    }
}
