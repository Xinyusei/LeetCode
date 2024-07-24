package lcRating.gt1400le1600;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * 1985. 找出数组中的第 K 大整数
 * https://leetcode.cn/problems/find-the-kth-largest-integer-in-the-array/description/
 */
public class a1985找出数组中的第K大整数 {
    class Solution {
        public String kthLargestNumber(String[] nums, int k) {
            Arrays.sort(nums, ((o1, o2) -> {
                if (o1.length() < o2.length())
                    return -1;
                else if (o1.length() > o2.length()) {
                    return 1;
                } else
                    return o1.compareTo(o2);
            }));
            System.out.println(Arrays.toString(nums));
            return nums[nums.length - k];
        }
    }
}
