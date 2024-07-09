package lcRating.le1200;

/**
 * 2710. 移除字符串中的尾随零
 * <a href="https://leetcode.cn/problems/remove-trailing-zeros-from-a-string/description/?envType=daily-question&envId=2024-07-09">...</a>
 */
public class a2710移除字符串中的尾随零 {
    class Solution {
        public String removeTrailingZeros(String num) {
            int i = num.length() - 1;
            for (; i >= 0; i--)
                if (num.charAt(i) != '0')
                    break;
            return num.substring(0, i + 1);
        }
    }

    class Solution2 {
        public boolean detectCapitalUse(String word) {
            if (word.length() <= 1)
                return true;
            if (isSmall(word.charAt(0))) {
                //所有必须为小写
                for (int i = 1; i < word.length(); i++) {
                    if (isLarge(word.charAt(i)))
                        return false;
                }
                return true;
                //第一个字母大写
            } else {
                //
                if (isLarge(word.charAt(1))) {
                    for (int i = 2; i < word.length(); i++) {
                        if (isSmall(word.charAt(i)))
                            return false;
                    }
                    return true;
                } else {
                    for (int i = 2; i < word.length(); i++) {
                        if (isLarge(word.charAt(i)))
                            return false;
                    }
                    return true;
                }
            }
        }

        public boolean isLarge(char a) {
            return a >= 'A' && a <= 'Z';
        }

        public boolean isSmall(char a) {
            return a >= 'a' && a <= 'z';
        }
    }
}
