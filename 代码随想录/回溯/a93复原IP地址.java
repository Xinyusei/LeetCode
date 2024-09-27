package 代码随想录.回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: ZJX
 * @Date: 2024/09/27
 * @Description:
 */
public class a93复原IP地址 {
    class Solution {
        private final List<String> res = new ArrayList<>();
        private final List<String> path = new LinkedList<>();

        public List<String> restoreIpAddresses(String s) {
            backtrack(0, s);
            return res;
        }

        //依旧是划分问题,


        private void backtrack(int startIndex, String s) {
            //到达叶子节点,划分完毕,将其保存到结果中
            if (startIndex >= s.length() && path.size() >= 4) {
                res.add(getRes(path));
                return;
            }

            for (int i = startIndex; i < s.length(); i++) {
                String v = s.substring(startIndex, i);
                if (isValidIp(v)) {
                    path.add(v);
                    backtrack(i + 1, s);
                    path.removeLast();
                }

            }
        }

        private String getRes(List<String> path) {
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < path.size(); i++) {
                s.append(path.get(i));
                if (i < path.size() - 1)
                    s.append('.');
            }
            return s.toString();
        }

        //判断某个字符串是否是有效的ip地址 0~255且没有前导0
        private boolean isValidIp(String s) {
            if (s.startsWith("0")) {
                return s.equals("0");
            }
            if (s.length() == 1)
                return s.charAt(0) <= '9';
            else if (s.length() == 2) {
                return s.compareTo("10") >= 0 && s.compareTo("99") <= 0;
            } else if (s.length() == 3) {
                return s.compareTo("100") >= 0 && s.compareTo("255") <= 0;
            }
            return false;
        }
    }
}
