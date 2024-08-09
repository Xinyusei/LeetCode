package lcRating.gt1400le1600;

/**
 * https://leetcode.cn/problems/minimum-moves-to-reach-target-score/description/
 *
 * @Author: ZJX
 * @Date: 2024/08/09
 * @Description: 1417 用时：6:36
 */
public class a2139得到目标值的最少行动次数 {
    class Solution {
        public int minMoves(int target, int maxDoubles) {
            int res = 0;
            while (target >= 1) {
                if (maxDoubles == 0) {
                    res += target - 1;
                    return res;
                }
                if ((target & 1) == 0) {
                    target >>= 1;
                    maxDoubles--;
                } else
                    target--;
                res++;
            }
            return res;
        }
    }
}
