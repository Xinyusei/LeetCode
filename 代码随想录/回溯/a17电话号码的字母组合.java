package 代码随想录.回溯;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: ZJX
 * @Date: 2024/09/25
 * @Description:
 */
public class a17电话号码的字母组合 {
    class Solution {

        private final List<String> res = new ArrayList<>();
        private final StringBuilder path = new StringBuilder();
        final HashMap<Character, String> record = new HashMap<>();

        {
            record.put('2', "abc");
            record.put('3', "def");
            record.put('4', "ghi");
            record.put('5', "jkl");
            record.put('6', "mno");
            record.put('7', "pqrs");
            record.put('8', "tuv");
            record.put('9', "wxyz");
        }

        public List<String> letterCombinations(String digits) {
            if (digits == null || digits.isEmpty())
                return new ArrayList<>();
            backtrack(0, digits);
            return res;
        }

        public void backtrack(int idx, String digits) {
            if (path.length() == digits.length() || idx == digits.length()) {
                //System.out.println("path : " + path + " 符合条件 ");
                res.add(new String(path));
                return;
            }

            char c = digits.charAt(idx);
            char[] cs = record.get(c).toCharArray();
            for (char value : cs) {
                //System.out.println("path : " + path + " 加入 : " + value);
                path.append(value);
                backtrack(idx + 1, digits);
                //System.out.println("path : " + path + " 撤销 : " + path.charAt(path.length() - 1));
                path.deleteCharAt(path.length() - 1);
            }
        }
    }
}
