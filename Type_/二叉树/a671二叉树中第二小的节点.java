package Type_.二叉树;

import Common.TreeNode;

/**
 * 671. 二叉树中第二小的节点
 * <a href="https://leetcode.cn/problems/second-minimum-node-in-a-binary-tree/description/">...</a>
 */
public class a671二叉树中第二小的节点 {
    class Solution {
        TreeNode first, second;

        public int findSecondMinimumValue(TreeNode root) {
            this.first = root;
            traverse(root);

            return second == null ? -1 : second.val;
        }

        public void traverse(TreeNode root) {
            if (root == null)
                return;
            if (root.val > first.val) {
                if (second == null || (second != null && root.val > second.val))
                    second = root;
            }
            if (root.left != null && root.left.val > root.val)
                traverse(root.left);
            if (root.right != null && root.right.val > root.val)
                traverse(root.right);
        }

    }

    class Solution2 {
        //找到以root为根的二叉树的第二小的节点。
        public int findSecondMinimumValue(TreeNode root) {
            if (root.left == root.right)
                return -1;
            // 左右子节点中不同于 root.val 的那个值可能是第二小的值
            int left = root.left.val, right = root.right.val;
            // 如果左右子节点都等于 root.val，则去左右子树递归寻找第二小的值
            if (root.val == root.left.val) {
                left = findSecondMinimumValue(root.left);
            }
            if (root.val == root.right.val) {
                right = findSecondMinimumValue(root.right);
            }
            if (left == -1)
                return right;
            if (right == -1)
                return left;
            // 如果左右子树都找到一个第二小的值，更小的那个是整棵树的第二小元素
            return Math.min(left, right);

        }
    }

}
