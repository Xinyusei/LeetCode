package Ev2024_1;

import java.util.*;

/**
 * mid-01-08
 * https://leetcode.cn/problems/number-of-boomerangs/description/?envType=daily-question&envId=2024-01-08
 * 翻译-每次从points数组中选一个点,从剩下的点中计算每个点到该点的距离,将其按照 距离：个数 存储在map中。
 * 每遍历完一个点,计算还有多少个点到其的距离相等。从中选出两个点
 */
public class 回旋镖的数量447 {
    public int numberOfBoomerangs(int[][] points) {
        //在循环外面new更快
        HashMap<Double, Integer> map = new HashMap<>();
        int ans = 0;
        for (int[] curP : points) {
            //每遍历一个点都需要更新
            map.clear();
            for (int[] otherP : points) {
                //计算其他点到当前点的距离
                Double dis = getDis(curP, otherP);
                int val;
                if (map.containsKey(dis))
                    val = map.get(dis) + 1;
                else
                    val = 1;
                map.put(dis, val);
            }
            for (Integer value : map.values()) {
                if (value >= 2) {
                    //注意这里需求顺序，故不需要/2
                    ans += value * (value - 1);
                }
            }
        }
        return ans;
    }

    //这里没有开平方,小技巧
    private double getDis(int[] point1, int[] point2) {
        return (point1[0] - point2[0]) * (point1[0] - point2[0]) + (point1[1] - point2[1]) * (point1[1] - point2[1]);
    }
}