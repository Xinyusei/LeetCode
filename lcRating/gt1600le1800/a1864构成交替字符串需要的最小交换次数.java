package lcRating.gt1600le1800;

import java.util.stream.Stream;

/**
 * @Author: ZJX
 * @Date: 2024/09/07
 * @Description:
 */
public class a1864构成交替字符串需要的最小交换次数 {
    class Solution {
        public int minSwaps(String s) {
            char[] chars = s.toCharArray();
            int n = s.length();
            int cnt1 = 0, cnt0 = 0, pos1 = 0;
            //cnt1表示'1'的个数,cnt0表示'0'的个数,pos1表示偶数位上'1'的个数
            for (int i = 0; i < n; i++) {
                if (chars[i] == '1') {
                    cnt1++;
                    if ((i & 1) == 0)
                        pos1++;
                } else
                    cnt0++;
            }
            if ((n & 1) == 0 && cnt1 != cnt0)
                return -1;
            if ((n & 1) != 0 && Math.abs(cnt0 - cnt1) != 1)
                return -1;
            //1 0 1 0 1 0
            //0 1 0 1 0 1
            //1 1 1 0 0 0 pos1 = 2
            if ((n & 1) == 0)
                return Math.min(pos1, n / 2 - pos1);
            else {
                if (cnt1 > cnt0)
                    //1 0 1 0 1
                    //1 1 1 0 0
                    return cnt1 - pos1;
                else
                    //0 1 0 1 0
                    //1 1 1 0 0
                    return pos1;

            }
        }
    }
}
