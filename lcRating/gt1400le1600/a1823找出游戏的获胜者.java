package lcRating.gt1400le1600;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/find-the-winner-of-the-circular-game/
 */
public class a1823找出游戏的获胜者 {
    class Solution1 {
        public int findTheWinner(int n, int k) {
            boolean[] vis = new boolean[n + 10];
            //cnt表示已经淘汰的个数,cur表示当前的位置
            int cnt = 0, cur = 0;
            while (cnt != n - 1) {
                //走过有效的k步
                for (int j = 0; j < k - 1; j++) {
                    cur++;
                    //如果已淘汰,就继续往后走(不算步数)
                    while (vis[cur % n])
                        cur++;
                }
                vis[cur % n] = true;
                System.out.println(cur);
                cnt++;
                cur++;
                while (vis[cur % n])
                    cur++;
            }
            return (cur % n) + 1;
        }
    }

    class Solution2 {
        public int findTheWinner(int n, int k) {
            LinkedList<Integer> queue = new LinkedList<>();
            for (int i = 1; i <= n; i++) {
                queue.addLast(i);
            }
            while (queue.size() > 1) {
                for (int i = 1; i < k; i++) {
                    queue.addLast(queue.removeFirst());
                }
                queue.removeFirst();
            }
            return queue.removeFirst();
        }
    }
}
