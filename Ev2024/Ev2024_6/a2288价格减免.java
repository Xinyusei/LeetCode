package Ev2024.Ev2024_6;

import static java.lang.Math.round;
import static java.lang.String.valueOf;

/**
 * 2288. 价格减免
 * https://leetcode.cn/problems/apply-discount-to-prices/description/?envType=daily-question&envId=2024-06-18
 */
public class a2288价格减免 {
    class Solution {
        public String discountPrices(String sentence, int discount) {
            String[] wordsList = sentence.split(" ");
            for (int i = 0; i < wordsList.length; i++) {
                String word = wordsList[i];
                if (!word.startsWith("$"))
                    continue;
                String toCheckWord = word.substring(1);
                if (toCheckWord.isEmpty())
                    continue;
                boolean flag = true;
                for (char c : toCheckWord.toCharArray()) {
                    if (!(c >= '0' && c <= '9')) {
                        flag = false;
                        break;
                    }
                }
                if (!flag)
                    continue;
                double price = Double.parseDouble(toCheckWord);
                String newWord = "$" + String.format("%.2f", price * 0.01 * (100 - discount));
                wordsList[i] = newWord;
            }
            return String.join(" ", wordsList);
        }
    }
}
