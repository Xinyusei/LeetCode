package lcRating.gt1400le1600;

import java.util.ArrayList;
import java.util.List;

/**
 * 1237. 找出给定方程的正整数解
 * https://leetcode.cn/problems/find-positive-integer-solution-for-a-given-equation/
 */
interface CustomFunction {
    public int f(int x, int y);
    // Returns some positive integer f(x, y) for two positive integers x and y based on a formula.
};

public class a1237找出给定方程的正整数解 {
    /**
     * 想向双指针
     *
     * @param customfunction
     * @param z
     * @return
     */
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> resList = new ArrayList<>();
        int x = 1, y = 1000;
        while (x <= 1000 && y >= 1) {
            int ans = customfunction.f(x, y);
            if (ans == z) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                arrayList.add(x);
                arrayList.add(y);
                resList.add(arrayList);
                x++;
                y--;
            } else if (ans < z) {
                x++;
            } else
                y--;
        }
        return resList;
    }


    public List<List<Integer>> findSolution2(CustomFunction customfunction, int z) {
        List<List<Integer>> resList = new ArrayList<>();
        int x = 1;
        while (x <= 1000) {
            int leftCase = 1, rightCase = 1000;
            while (leftCase < rightCase) {
                int y = (leftCase + rightCase) >> 1;
                int ans = customfunction.f(x, y);
                if (ans == z) {
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    arrayList.add(x);
                    arrayList.add(y);
                    resList.add(arrayList);
                    break;
                } else if (ans < z) {
                    leftCase = y + 1;
                } else
                    rightCase = y;
            }
            x++;
        }
        return resList;
    }
}
