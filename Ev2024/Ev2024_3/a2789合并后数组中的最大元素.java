package Ev2024.Ev2024_3;

import java.util.Arrays;

public class a2789合并后数组中的最大元素 {
    public long maxArrayValue(int[] nums) {
        int n = nums.length;
        long res = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < res)
                res += nums[i];
            else
                res = nums[i];
        }
        return res;
    }



    public long maxArrayValue2(int[] nums) {
        long res = 0;
        int n = nums.length;
        long[] Num = new long[n];
        for (int i = 0; i < nums.length; i++) {
            Num[i] = nums[i];
        }
        for (int i = n - 1; i >= 0; i--) {
            if (i >= 1 && Num[i] >= Num[i - 1]) {
                Num[i] += Num[i - 1];
                Num[i - 1] = Num[i];
            }
            if (Num[i] > res)
                res = Num[i];
        }
        return res;
    }
}



