package Ev2024.Ev2024_6;

/**
 * 1103. 分糖果 II
 */
public class a1103分糖果II {
    class Solution {
        public int[] distributeCandies(int candies, int num_people) {
            int[] f = new int[num_people];
            int idx = 0, cnt = 1;
            while (candies > 0) {
                if (candies >= cnt) {
                    f[idx] += cnt;
                    candies -= cnt;
                } else {
                    f[idx] += candies;
                    break;
                }
                cnt++;
                idx = (idx + 1) % num_people;
            }
            return f;
        }
    }
}


