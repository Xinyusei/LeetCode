package Ev2024.Ev2024_1;

import java.util.Arrays;

/**
 * 2171. 拿出最少数目的魔法豆
 * https://leetcode.cn/problems/removing-minimum-number-of-magic-beans/?envType=daily-question&envId=2024-01-18
 */
public class a1_18mid {
    //1 4 5 6 -> 1 1 1 1 / 0 4 4 4 / 0 0 5 5 / 0 0 0 6
    //2 2 3 10 -> 2 2 2 2 / 0 0 3 3 / 0 0 0 10
    public long minimumRemoval(int[] beans) {
        int n = beans.length;
        Arrays.sort(beans);
        long total = 0;
        for (int bean : beans) {
            total += bean;
        }
        //total计算总的豆子
        long res = total;
        for (int i = 0; i < n; i++) {
            //计算最后剩的豆子,比如 0 4 4 4 ,拿出的豆子就是total - 4->beans[1] * (4->n - 1))
            res = Math.min(res, total - (long)beans[i] * (n - i));
        }
        return res;
    }
}
