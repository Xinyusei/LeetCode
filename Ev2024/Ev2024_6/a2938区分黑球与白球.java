package Ev2024.Ev2024_6;

/**
 * 2938. 区分黑球与白球
 * https://leetcode.cn/problems/separate-black-and-white-balls/description/?envType=daily-question&envId=2024-06-07
 */
public class a2938区分黑球与白球 {
    class Solution {
        public long minimumSteps(String s) {
            //1010001
            //0110001
            int n = s.length();
            long black = 0,ans = 0;
            for (int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == '1')
                    black++;
                else
                    ans += black;
            }
            return ans;
        }
    }
}
