package Ev2024.Ev2024_2;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.cn/problems/stone-game-vi/
 * 1686. 石子游戏 VI
 */
public class a2_2MID {
    /**
     * 贪心+思维
     *
     * @param aliceValues
     * @param bobValues
     * @return
     */
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int n = aliceValues.length, diff = 0;
        Integer[][] ints = new Integer[n][3];
        for (int i = 0; i < ints.length; i++) {
            ints[i][0] = aliceValues[i] + bobValues[i];
            ints[i][1] = i;
            ints[i][2] = i;
        }
        Arrays.sort(ints, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return o2[0] - o1[0];
            }
        });
        for (int i = 0; i < ints.length; i++) {
            if ((i & 1) == 0)
                diff += aliceValues[ints[i][1]];
            else
                diff -= bobValues[ints[i][2]];
        }
        if (diff > 0)
            return 1;
        else if (diff < 0) {
            return -1;
        } else
            return 0;
    }
}
