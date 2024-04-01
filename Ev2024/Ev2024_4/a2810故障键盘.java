package Ev2024.Ev2024_4;

import Ev2024.Ev2024_1.赎金信;

/**
 * <a href="https://leetcode.cn/problems/faulty-keyboard/description/?envType=daily-question&envId=2024-04-01">2810. 故障键盘</a>
 */
public class a2810故障键盘 {
    public String finalString(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != 'i')
                sb.append(s.charAt(i));
            else
                sb.reverse();
        }
        return sb.toString();
    }
}
