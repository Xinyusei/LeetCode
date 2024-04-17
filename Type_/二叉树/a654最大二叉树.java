package Type_.二叉树;

import Common.TreeNode;

import java.util.Arrays;

/**
 * 654. 最大二叉树
 * https://leetcode.cn/problems/maximum-binary-tree/description/
 */
public class a654最大二叉树 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length - 1);
    }
    /**
     * 构造二叉树
     *
     * @param nums
     * @param lo
     * @param hi
     * @return
     */
    TreeNode construct(int[] nums, int lo, int hi) {
        if (lo > hi)
            return null;
        int idx = -1, MaxVal = Integer.MIN_VALUE;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] > MaxVal) {
                MaxVal = nums[i];
                idx = i;
            }
        }
        TreeNode root = new TreeNode(nums[idx]);
        root.left = construct(nums, lo, idx - 1);
        root.right = construct(nums, idx + 1, hi);
        return root;
    }
}
