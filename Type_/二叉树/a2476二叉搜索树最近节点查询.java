package Type_.二叉树;

import Common.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2476. 二叉搜索树最近节点查询
 * https://leetcode.cn/problems/closest-nodes-queries-in-a-binary-search-tree/description/?envType=daily-question&envId=2024-02-24
 */
public class a2476二叉搜索树最近节点查询 {
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        traverse(root, list);
        int n = list.size();
        List<List<Integer>> res = new ArrayList<>();
        for (Integer val : queries) {
            int idx = binarySearch(list, val);
            int minVal = -1, maxVal = -1;
            //存在大于等于val的元素
            if (idx != n) {
                maxVal = list.get(idx);
                if (maxVal == val) {
                    minVal = val;
                    res.add(List.of(minVal, maxVal));
                    continue;
                }
            }

            if (idx > 0) {
                minVal = list.get(idx - 1);
            }
            res.add(List.of(minVal, maxVal));
        }

        return res;
    }


    /**
     * 得到大于等于val的最小元素的索引
     *
     * @param list
     * @param val
     * @return
     */
    public int binarySearch(List<Integer> list, int val) {
        int lo = 0, hi = list.size();
        while (lo < hi) {
            int mid = lo + (hi - lo) >> 1;
            if (list.get(mid) < val)
                lo = mid + 1;
            else
                hi = mid;
        }
        return lo;
    }

    /**
     * 中序遍历BST获得递增序列
     *
     * @param root
     * @return
     */
    public void traverse(TreeNode root, List<Integer> arr) {
        if (root == null)
            return;
        traverse(root.left, arr);
        arr.add(root.val);
        traverse(root.right, arr);
    }
}
