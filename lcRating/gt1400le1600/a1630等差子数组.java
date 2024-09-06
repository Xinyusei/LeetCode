package lcRating.gt1400le1600;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Author: ZJX
 * @Date: 2024/09/06
 * @Description:
 */
public class a1630等差子数组 {
    class Solution {
        public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
            int m = l.length;
            List<Boolean> arr = new ArrayList<>(m);

            for (int i = 0; i < m; i++) {
                int[] cur = Arrays.copyOfRange(nums, l[i], r[i] + 1);
                //Arrays.sort(cur);
                arr.add(isSameDiffByMinMax(cur));
            }
            return arr;
        }

        /**
         * 排序判断是否是等差数列
         *
         * @param nums
         * @return
         * @author ZJX
         * @date 2024/09/06
         */
        public boolean isSameDiffBySort(int[] nums) {
            if (nums.length == 1)
                return false;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] - nums[i - 1] != nums[1] - nums[0])
                    return false;
            }
            return true;
        }

        /**
         * 遍历一次得到数列的最小最大值,如果是等差数列,则该等差数据已经确定
         * @author ZJX
         * @date 2024/09/06
         * @param nums
         * @return
         */
        public boolean isSameDiffByMinMax(int[] nums) {
            if (nums.length == 1)
                return false;
            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, n = nums.length;
            boolean[] exits = new boolean[n];
            for (int num : nums) {
                min = Math.min(num, min);
                max = Math.max(num, max);
            }
            if (min == max)
                return true;
            //4,6,5
            if ((max - min) % (n - 1) != 0)
                return false;
            int d = (max - min) / (n - 1);
            for (int num : nums) {
                int D = num - min;
                if (D % d != 0 || exits[D / d])
                    return false;
                exits[D / d] = true;
            }
            return true;
        }
    }
}
