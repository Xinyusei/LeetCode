package Ev2024.Ev2024_3;

/**
 * 2575. 找出字符串的可整除数组
 * https://leetcode.cn/problems/find-the-divisibility-array-of-a-string/description/?envType=daily-question&envId=2024-03-07
 */

public class a2575找出字符串的可整除数组 {
    public int[] divisibilityArray(String word, int m) {
        //[0:i−1] 所代表的数能被 mmm 整除，则 [0:i]所代表的数能否被 m 整除 取决于 nums[i] 能否被 m 整除。
        
        //取余递推的正确性证明：
        //设 [0:i-1]代表的数为 k * m + mod,[0:i]代表的数为 10 *(k * m + mod) + nums[i]
        //则 (10×(k×m+mod)+nums[i]) % m=(10×mod+nums[i]) % m
        int n = word.length();
        int[] div = new int[n];
        long mod = 0;
        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);
            mod = (mod * 10 + (c - '0')) % m;
            div[i] = (mod == 0) ? 1 : 0;
        }
        return div;
    }
}
