package Type_.差分.一维差分;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: ZJX
 * @Date: 2024/09/12
 * @Description:
 */
public class a2848与车相交的点 {
    class Solution {
        public int numberOfPoints(List<List<Integer>> nums) {
            int[] d = new int[101];
            for (List<Integer> num : nums) {
                int from = num.getFirst(), to = num.getLast();
                d[from]++;
                d[to + 1]--;
            }
            System.out.println(Arrays.toString(d));
            //0,1,0,0,-1,1,0,0,0,-1
            //0,1,1,1,0,1,1,1,1,0
            int ans = 0;
            int s = 0;
            for (int i : d) {
                s += i;
                if (s > 0) {
                    ans++;
                }
            }
            return ans;
        }
    }
}
