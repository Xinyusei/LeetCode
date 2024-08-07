package lcRating.gt1400le1600;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/defuse-the-bomb/">1652拆炸弹</a>
 *
 * @Author: ZJX
 * @Date: 2024/08/07
 * @Description: 1417 , 用时:35分钟
 */
public class a1652拆炸弹 {
    class Solution {
        public int[] decrypt(int[] code, int k) {
            //5,7,1,4,5,7,1,4
            int n = code.length, dis = Math.abs(k);
            int[] s = new int[n * 2];
            System.arraycopy(code, 0, s, 0, n);
            System.arraycopy(code, 0, s, n, n);
            //System.out.println(Arrays.toString(s));
            int[] res = new int[n];
            if (k == 0)
                return res;
            for (int i = 0; i < res.length; i++) {
                if (k > 0) {
                    for (int j = 0; j < dis; j++)
                        res[i] += s[i + j + 1];
                }
                else {
                    for (int j = n - dis; j < n; j++)
                        res[i] += s[i + j];
                }
            }
            return res;
        }
    }
}
