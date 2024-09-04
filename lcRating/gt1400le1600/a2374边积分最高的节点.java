package lcRating.gt1400le1600;

import java.util.*;

/**
 * @Author: ZJX
 * @Date: 2024/09/04
 * @Description:
 */
public class a2374边积分最高的节点 {
    class Solution {

        public int edgeScore(int[] edges) {
            int n = edges.length;
            long[] score = new long[n];
            long max = -1;
            int maxIdx = -1;
            //3
            for (int i = 0; i < edges.length; i++) {
                score[edges[i]] += i;
                if (max < score[edges[i]]) {
                    max = score[edges[i]];
                    maxIdx = edges[i];
                }
            }
            return maxIdx;
        }
    }

    class Solution2 {

        public int edgeScore(int[] edges) {
            int n = edges.length;
            Map<Integer, Integer> score = new HashMap<>();

            for (int i = 0; i < edges.length; i++) {
                score.put(edges[i], score.getOrDefault(edges[i], 0) + i);
            }
            int maxScore = 0;
            int ans = 0;
            for (Map.Entry<Integer, Integer> e : score.entrySet()) {
                if (maxScore < e.getValue()) {
                    maxScore = e.getValue();
                    ans = e.getKey();
                }
            }
            return ans;
        }
    }
}

