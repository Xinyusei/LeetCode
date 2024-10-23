package lcRating.gt1400le1600;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: ZJX
 * @Date: 2024/10/22
 * @Description: 类似于括号匹配
 */
public class a1003检查替换后的词是否有效 {
    class Solution {
        public boolean isValid(String s) {
            //1.n个
            List<Character> stack = new LinkedList<>();

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == 'a')
                    stack.addLast('a');
                else if (c == 'b') {
                    if (stack.isEmpty() || stack.getLast() != 'a')
                        return false;
                    stack.addLast('b');
                } else {
                    if (stack.isEmpty() || stack.getLast() != 'b')
                        return false;
                    stack.removeLast();
                    stack.removeLast();
                }
            }
            return stack.isEmpty();
        }
    }
}
