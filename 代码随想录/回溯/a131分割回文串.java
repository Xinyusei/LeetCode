package 代码随想录.回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: ZJX
 * @Date: 2024/09/27
 * @Description:
 */
public class a131分割回文串 {
    class Solution {

        private final List<List<String>> ans = new ArrayList<>();

        private final List<String> path = new LinkedList<>();

        public List<List<String>> partition(String s) {
            backtrack(0, s);
            return ans;
        }

        private void backtrack(int start, String s) {
            //到达叶子节点
            if (start >= s.length()) {
                //System.out.println("path : " + path + " 满足条件 ");
                ans.add(new LinkedList<>(path));
                return;
            }

            for (int i = start; i < s.length(); i++) {
                //如果当前子串是回文串,则加入路径中,否则直接跳过当前节点

                if (isPalindrome(s, start, i)) {
                    String v = s.substring(start, i + 1);
                    //System.out.println("path : " + path + " i的值为 : " + i + " start的值为 : " + start + " 本轮加入选择 : " + v);
                    path.add(v);
                    backtrack(i + 1, s);
                    //System.out.println("path : " + path + " i的值为 : " + i + " start的值为 : " + start + " 本轮撤销选择 : " + path.getLast());
                    path.removeLast();
                }
            }
        }

        //判断字符串s是否是回文串
        private boolean isPalindrome(String s, int lo, int hi) {
            for (; lo <= hi; lo++, hi--) {
                if (s.charAt(lo) != s.charAt(hi))
                    return false;
            }
            return true;
        }
    }
}
