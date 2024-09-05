package lcRating.gt1400le1600;

import java.util.Arrays;

/**
 * @Author: ZJX
 * @Date: 2024/09/05
 * @Description:
 */
public class a1033移动石子直到连续 {
    class Solution {
        public int[] numMovesStones(int a, int b, int c) {
            int[] arr = {a, b, c};
            Arrays.sort(arr);


            //1,5,10
            int maxMove = 0, minMove = 0;
            int d1 = arr[1] - arr[0];
            int d2 = arr[2] - arr[1];
            if (d1 == 1 && d2 == 1) {
                return new int[]{0, 0};
            }
            if (d1 == 1 || d2 == 1) {
                minMove = 1;
                maxMove = Math.max(d2, d1) - 1;
            } else if (d1 == 2 || d2 == 2) {
                minMove = 1;
                maxMove = d2 + d1 - 2;
            } else {
                minMove = 2;
                maxMove = d2 + d1 - 2;
            }
            return new int[]{minMove, maxMove};
        }
    }

    class Solution2 {
        public int[] numMovesStones(int a, int b, int c) {
            int x = Math.min(Math.min(a, b), c);
            int z = Math.max(Math.max(a, b), c);
            int y = a + b + c - x - z;

            int d1 = y - x;
            int d2 = z - y;
            int minMove = 0,maxMove = 0;
            if (d1 == 1 && d2 == 1) {
                return new int[]{0, 0};
            }
            else if (d1 == 1 || d2 == 1) {
                minMove = 1;
                maxMove = Math.max(d2, d1) - 1;
            } else if (d1 == 2 || d2 == 2) {
                minMove = 1;
                maxMove = d2 + d1 - 2;
            } else {
                minMove = 2;
                maxMove = d2 + d1 - 2;
            }
            return new int[]{minMove, maxMove};
        }
    }
}
