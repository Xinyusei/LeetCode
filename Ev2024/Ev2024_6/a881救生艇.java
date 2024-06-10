package Ev2024.Ev2024_6;

import java.util.Arrays;

/**
 * 881. 救生艇
 * https://leetcode.cn/problems/boats-to-save-people/description/?envType=daily-question&envId=2024-06-10
 */
public class a881救生艇 {
    class Solution {
        public int numRescueBoats(int[] people, int limit) {
            //3,3,4,5   3
            Arrays.sort(people);
            int cnt = 0;
            int hi = people.length - 1;
            while (people[hi] > limit)
                hi--;
            cnt += people.length - hi - 1;
            int lo = 0;
            while (lo <= hi) {
                if (people[lo] + people[hi] <= limit) {
                    lo++;
                }
                hi--;
                cnt++;
            }
            return cnt;
        }
    }
}
