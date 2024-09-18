package Type_.前缀和.基础;

import jdk.jshell.execution.Util;

import java.util.Arrays;
import java.util.Map;

/**
 * @Author: ZJX
 * @Date: 2024/09/18
 * @Description:
 */
public class a2389和有限的最长子序列 {
    class Solution {
        public int[] answerQueries(int[] nums, int[] queries) {
            Arrays.sort(nums);
            //1,2,4,5
            //0,1,3,7,12
            //3,10,21
            int n = nums.length;
            int[] d = new int[n + 1];
            for (int i = 0; i < n; i++) {
                d[i + 1] = d[i] + nums[i];
            }
            for (int i = 0; i < queries.length; i++) {
                queries[i] = bs(d, queries[i]);
            }
            return queries;
        }

        private int bs(int[] nums, int s) {
            int lo = 0, hi = nums.length;
            while (lo < hi) {
                int mid = (hi - lo) / 2 + lo;
                //[lo,mid) mid [mid+1,hi)
                if (nums[mid] == s)
                    return mid;
                else if (nums[mid] > s)
                    hi = mid;
                else
                    lo = mid + 1;
            }
            if (lo == nums.length || nums[lo] > s)
                return lo - 1;
            return lo;
        }
    }
}
