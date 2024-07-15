package lcRating.gt1400le1600;

import java.util.*;

/**
 * 1217. 玩筹码
 * https://leetcode.cn/problems/minimum-cost-to-move-chips-to-the-same-position/description/
 */
public class a1217玩筹码 {
    class Solution1 {
        public int minCostToMoveChips(int[] position) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int p : position) {
                map.put(p, map.getOrDefault(p, 0) + 1);
            }
            int res = Integer.MAX_VALUE;
            Set<Integer> Ps = map.keySet();
            for (Integer curP : Ps) {
                int curCost = 0;
                for (Integer otherP : Ps) {
                    if ((Math.abs(otherP - curP)) % 2 != 0)
                        curCost += map.get(otherP);
                }
                res = Math.min(res, curCost);
            }
            return res;
        }
    }

    class Solution2 {

        public int minCostToMoveChips(int[] position) {
            int odd = 0, even = 0;
            for (int p : position) {
                if ((p & 1) == 0)
                    even++;
                else
                    odd++;
            }
            return Math.min(odd, even);

        }

    }
}
