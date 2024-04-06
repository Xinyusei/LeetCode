package Type_.二叉树;

import Common.TreeNode;

/**
 * 108. 将有序数组转换为二叉搜索树
 * https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/description/
 */
public class a108将有序数组转换为二叉搜索树 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    public TreeNode build(int[] nums, int lo, int hi) {
        if (lo > hi)
            return null;
        int idx = (lo + hi) / 2;
        TreeNode root = new TreeNode(nums[idx]);
        root.left = build(nums, lo, idx - 1);
        root.right = build(nums, idx + 1, hi);

        return root;

    }
}
