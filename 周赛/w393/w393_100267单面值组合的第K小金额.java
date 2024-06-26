package 周赛.w393;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class w393_100267单面值组合的第K小金额 {
    class Solution {
        public long findKthSmallest(int[] coins, int k) {
            PriorityQueue<Integer>[] arr = (PriorityQueue<Integer>[]) new List[coins.length];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = new PriorityQueue<>();
            }
            for (int i = 0; i < coins.length; i++) {
                int coin = coins[i];
                for (int j = 1; j <= k; j++) {
                    arr[i].add((int) Math.pow(coin, j));
                }
            }
            return 0;
        }
    }
}
