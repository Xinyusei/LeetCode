package Ev2024.Ev2024_6;

import java.util.HashSet;
import java.util.Set;

/**
 * 521. 最长特殊序列 Ⅰ
 * https://leetcode.cn/problems/longest-uncommon-subsequence-i/?envType=daily-question&envId=2024-06-17
 */
public class a521最长特殊序列I {
    class Solution {
        public int findLUSlength(String a, String b) {
            return !a.equals(b) ? Math.max(a.length(), b.length())  : -1;
        }
    }
}
