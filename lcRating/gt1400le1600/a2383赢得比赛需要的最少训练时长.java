package lcRating.gt1400le1600;

/**
 * 2383. 赢得比赛需要的最少训练时长
 * https://leetcode.cn/problems/minimum-hours-of-training-to-win-a-competition/description/
 */
public class a2383赢得比赛需要的最少训练时长 {
    class Solution {
        public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
            int n = energy.length;
            int res = 0;
            for (int i = 0; i < n; i++) {
                if (initialEnergy <= energy[i]) {
                    int dEn = energy[i] - initialEnergy + 1;
                    res += dEn;
                    initialEnergy += dEn;
                }
                initialEnergy -= energy[i];
                if (initialExperience <= experience[i]) {
                    int dEx = experience[i] - initialExperience + 1;
                    res += dEx;
                    initialExperience += dEx;
                }
                initialExperience += experience[i];
            }
            return res;
        }
    }
}

