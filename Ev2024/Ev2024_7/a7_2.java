package Ev2024.Ev2024_7;

/**
 * <a href="https://leetcode.cn/problems/nim-game/?envType=daily-question&envId=2024-07-02">292. Nim 游戏</a>
 */
public class a7_2 {
    class Solution {
        public boolean canWinNim(int n) {
            return (n & 3 ) != 0;
        }
    }
}
