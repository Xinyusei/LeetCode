package lcRating.gt1400le1600;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/minimum-rectangles-to-cover-points/description/">...</a>
 */
public class a3111覆盖所有点的最少矩形数目 {
    class Solution {
        public int minRectanglesToCoverPoints(int[][] points, int w) {
            List<Integer> arr = new ArrayList<>();
            for (int[] point : points) {
                arr.add(point[0]);
            }
            arr.sort(Comparator.comparingInt(o -> o));
            int res = 1;
            int cur = arr.getFirst() + w;
            //1,2,3,4
            for (Integer x : arr) {
                if (x <= cur)
                    continue;
                cur = x + w;
                res++;
            }
            return res;
        }
    }
}
