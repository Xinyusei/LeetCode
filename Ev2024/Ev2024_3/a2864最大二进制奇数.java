package Ev2024.Ev2024_3;

/**
 * 2864. 最大二进制奇数
 * https://leetcode.cn/problems/maximum-odd-binary-number/description/?envType=daily-question&envId=2024-03-13
 */
public class a2864最大二进制奇数 {
    public String maximumOddBinaryNumber(String s) {
        int count = -1;
        for (char c : s.toCharArray()) {
            if (c == '1')
                count++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append('1');
        }
        for (int i = count; i < s.length() - 1; i++) {
            sb.append('0');
        }
        sb.append('1');
        return sb.toString();
    }
}
