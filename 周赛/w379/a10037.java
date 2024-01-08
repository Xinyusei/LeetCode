package 周赛.w379;

import java.util.*;

/**
 * 10037. 移除后集合的最多元素数
 * https://leetcode.cn/problems/maximum-size-of-a-set-after-removals/description/
 */
public class a10037 {
    public int maximumSetSize(int[] nums1, int[] nums2) {
        //set1代表nums1的不同元素
        Set<Integer> set1 = new HashSet<>();
        //set2代表nums2的不同元素
        Set<Integer> set2 = new HashSet<>();

        //common代表nums1和nums2的不同元素的交集个数
        int common = 0;
        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            set2.add(i);
        }

        for (Integer i : set1) {
            if (set2.contains(i))
                //交集个数
                common++;
        }
        //m代表需要nums1和nums2均需要移除的元素的个数
        int m = nums1.length / 2;
        //n1和n2分别代表nums1,nums2不同元素个数
        int n1 = set1.size(), n2 = set1.size();
        //如果不移除任何元素，根据容斥原理 nums1和nums2的并集一共有 n1+n2-common个不同元素
        int ans = n1 + n2 - common;
        //我们可以先移除每个数组中的重复元素，再考虑从剩下的数中移除元素。

        //如果n1<=m && n2 <= m,则对结果没有影响
        //但如果n1>m,先从nums1和nums2的交集中移除元素
        if (n1 > m) {
            int mn = Math.min(n1 - m, common);
            common -= mn;
            ans -= n1 - m - mn;
        }
        if (n2 > m) {
            n2 -= Math.min(n2 - m, common);
            ans -= n2 - m;
        }

        return ans;
    }


}
