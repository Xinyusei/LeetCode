package lcRating.gt1400le1600;

import java.util.Arrays;

public class a2734执行子串操作后的字典序最小字符串 {
    public String smallestString(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length, flag = 0;
        for (int i = 0; i < n; i++) {
            if (chars[i] > 'a') {
                for (; i < n && chars[i] > 'a'; i++) {
                    chars[i]--;
                }
                return new String(chars);
            }
        }
        chars[n - 1] = 'z';
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println((int) 'a');
        System.out.println((int) 'z');
        //97 - 96 98-97  ... 122 - 97
    }
}
