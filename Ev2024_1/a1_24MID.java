package Ev2024_1;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/beautiful-towers-i/?envType=daily-question&envId=2024-01-24
 * 2865. 美丽塔 I
 */
public class a1_24MID {
    /**
     * 时间复杂度0(n²) 空间复杂度0(1)
     */
    //5 3 4 1 1
    //5种可能
    //5 3 3 1 1
    //3 3 3 1 1
    //3 3 4 1 1
    //1 1 1 1 1
    //1 1 1 1 1
    /*
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        long res = 0;
        for (int i = 0; i < maxHeights.size(); i++) {
            long mountain = maxHeights.get(i), leftMax = mountain, rightMax = mountain, curRes = mountain;
            for (int left = i - 1; left >= 0; left--) {
                leftMax = Math.min(leftMax, maxHeights.get(left));
                curRes += leftMax;
            }
            for (int right = i + 1; right < maxHeights.size(); right++) {
                rightMax = Math.min(rightMax, maxHeights.get(right));
                curRes += rightMax;
            }
            if (res < curRes)
                res = curRes;
        }
        return res;
    }
    */

    /**
     * 单调栈+dp
     * @param maxHeights
     * @return
     */
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        //TODO 
        return 0;
    }
}
