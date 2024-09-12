package Type_.差分.一维差分;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Author: ZJX
 * @Date: 2024/09/12
 * @Description:
 */
public class a1094拼车 {
    class Solution {
        public boolean carPooling(int[][] trips, int capacity) {
            int[] d = new int[1001];
            for (int[] trip : trips) {
                int num = trip[0], from = trip[1], to = trip[2];
                d[from] += num;
                d[to] -= num;
            }
            //System.out.println(Arrays.toString(d));
            //0 2 0 3 0 -2 0 -3
            int max = 0;
            for (int i : d) {
                max += i;
                if (max > capacity)
                    return false;
            }
            return true;
        }
    }
}
