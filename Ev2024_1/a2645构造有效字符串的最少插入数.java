package Ev2024_1;

/**
 * https://leetcode.cn/problems/minimum-additions-to-make-valid-string/description/?envType=daily-question&envId=2024-01-11
 * 2645. 构造有效字符串的最少插入数
 */
public class a2645构造有效字符串的最少插入数 {
    public int addMinimum(String word) {
        //灵神的解法:
        //如果 考虑 aaa s[0]>=s[1],第一个a和第二a必定不存在于同一个abc中
        // s[1]>=s[2] 第二个a和第三a必定不存在于同一个abc中
        //turn就是有多少个abc -最后的word一定是turn个abc构成的(turn>=1)
        //考虑 a b a s[0] < s[1] 位于同一个abc中
        // s[1]<=s[2] 必定位于不同的abc中
        int turn = 1;
        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i - 1) >= word.charAt(i)) {
                turn++;
            }
        }
        return 3 * turn - word.length();
    }

}
