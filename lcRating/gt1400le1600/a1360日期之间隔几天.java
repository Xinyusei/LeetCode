package lcRating.gt1400le1600;

/**
 * @Author: ZJX
 * @Date: 2024/09/05
 * @Description:
 */
public class a1360日期之间隔几天 {
    class Solution {
        private final int[][] Month = {{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},
                {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}};
        private final int[] Day = {365, 366};
        public int daysBetweenDates(String date1, String date2) {

            String[] s1 = date1.split("-");
            String[] s2 = date2.split("-");

            int y1 = Integer.parseInt(s1[0]), y2 = Integer.parseInt(s2[0]);
            int m1 = Integer.parseInt(s1[1]), m2 = Integer.parseInt(s2[1]);
            int d1 = Integer.parseInt(s1[2]), d2 = Integer.parseInt(s2[2]);
            int dis1 = gap(y1, m1, d1);
            int dis2 = gap(y2, m2, d2);
            return Math.abs(dis1 - dis2);

        }

        //计算一个日期与1971.01.01日的日期差
        public int gap(int y, int m, int d) {
            int sum = 0;
            int flag = isLeapYear(y);

            for (int i = 1971; i < y; i++) {
                sum += Day[isLeapYear(i)];
            }
            for (int i = 0; i < m; i++) {
                sum += Month[flag][i];
            }
            sum += d;
            return sum;
        }
        public int isLeapYear(int year) {
            if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
                return 1;
            return 0;
        }
    }
}
