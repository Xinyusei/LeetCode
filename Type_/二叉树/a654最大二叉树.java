package Type_.二叉树;

import Common.TreeNode;

import java.util.Arrays;

/**
 * 654. 最大二叉树
 * https://leetcode.cn/problems/maximum-binary-tree/description/
 */
public class a654最大二叉树 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        //base case
//        if (nums.length == 0)
//            return null;
//
//        int idx = 0;
//        for (int i = 1; i < nums.length; i++) {
//            if (nums[idx] > nums[i])
//                idx = i;
//        }
//        TreeNode node = new TreeNode(nums[idx]);
//        node.left = constructMaximumBinaryTree(Arrays.copyOfRange(nums, 0, idx));
//        node.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums, idx + 1, nums.length));
//        return node;

        return construct(nums, 0, nums.length - 1);
    }


    TreeNode construct(int[] nums, int lo, int hi) {
        if (lo > hi)
            return null;

        int idx = -1, maxVal = Integer.MIN_VALUE;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] > maxVal) {
                maxVal = nums[i];
                idx = i;
            }
        }
        TreeNode root = new TreeNode(maxVal);
        root.left = construct(nums, lo, idx - 1);
        root.right = construct(nums, idx + 1, hi);

        return root;


    }
}
