package lcRating.gt1400le1600;

import java.util.LinkedList;
import java.util.List;

/**
 * 1006. 笨阶乘
 * https://leetcode.cn/problems/clumsy-factorial/description/
 */
public class a1006笨阶乘 {
    class Solution {
        public int clumsy(int n) {
            List<Integer> stack = new LinkedList<>();
            stack.addFirst(n);
            n--;

            int idx = 0;
            while (n >= 1) {
                if (idx % 4 == 0) //乘
                    stack.addFirst(stack.removeFirst() * n);
                else if (idx % 4 == 1) //除
                    stack.addFirst(stack.removeFirst() / n);
                else if (idx % 4 == 2) //加
                    stack.addFirst(n);
                else
                    stack.addFirst(-n);
                idx++;
                n--;
            }
            int res = stack.removeFirst();
            while (!stack.isEmpty()) {
                res += stack.removeFirst();
            }
            return res;
        }
    }
}
