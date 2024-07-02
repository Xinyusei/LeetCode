package Ev2024.Ev2024_7;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/jump-game-vi/?envType=daily-question&envId=2024-07-02">1696. 跳跃游戏 VI</a>
 */
public class a7_1 {
    class Solution {
        public int maxResult(int[] nums, int k) {
            int n = nums.length;
            int[] f = new int[n];
            f[0] = nums[0];
            List<Integer> queue = new LinkedList<>();
            queue.addLast(0);
            for (int i = 1; i < n; i++) {
                if(queue.getFirst() < i - k)
                    queue.removeFirst();
                f[i] = f[queue.getFirst()] + nums[i];

                while (!queue.isEmpty() && f[i] >= f[queue.getLast()])
                    queue.removeLast();

                queue.addLast(i);
            }
            //System.out.println(Arrays.toString(f));
            return f[n - 1];
        }
    }
}
