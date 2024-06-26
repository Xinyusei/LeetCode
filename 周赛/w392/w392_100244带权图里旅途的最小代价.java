package 周赛.w392;

import java.util.ArrayList;
import java.util.List;

public class w392_100244带权图里旅途的最小代价 {
    class Solution {
        public int[] minimumCost(int n, int[][] edges, int[][] query) {
            List<Integer>[] g = new List[n];
            for (int i = 0; i < n; i++) {
                g[i] = new ArrayList<>();
            }

            for (int[] edge : edges) {
                g[edge[0]].add(edge[1]);
            }

            return null;
        }
    }
}
